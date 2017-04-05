package banco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CuentaBancaria {

    private long numCuenta;
    private double saldo;
    private Persona titular;
    public Set<Persona> listaTitulares = new HashSet<>();
    public List<Autorizacion> listaAutorizados = new ArrayList<>();
    public List<Movimiento> listaMovimientos = new ArrayList<>();

    public CuentaBancaria(long ncuenta, Persona titular) {
        this.numCuenta = ncuenta;
        this.titular = titular;
        this.saldo = 0;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public Persona getTitular() {
        return titular;
    }

    public void SetTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Autorizacion> getListaAutorizados() {
        return listaAutorizados;
    }

    public Set<Persona> getListaTitulares() {
        return listaTitulares;
    }

    public void setListaAutorizados(List<Autorizacion> listaAutorizados) {
        this.listaAutorizados = listaAutorizados;
    }

    public Autorizacion existePersona(Persona autorizado) {
        Autorizacion per = null;
        boolean existe = false;
        for (int i = 0; i < listaAutorizados.size() && !existe; i++) {
            per = listaAutorizados.get(i);
            if (per.getPersona().igual(autorizado)) {
                existe = true;
            } else {
                per = null;
            }
        }
        return per;
    }

    public Persona existeTitular(Persona autorizado) {
        Persona per = null;
        boolean existe = false;
        Iterator<Persona> it = this.listaTitulares.iterator();
        while (it.hasNext() && !existe) {
            per = it.next(); //devuelve el elemento
            if (per.igual(autorizado)) {
                existe = true;
            } else {
                per = null;
            }
        }
        return per;
    }

    public boolean autorizar(Autorizacion autorizado) {
        boolean auto = false;

        if (this.existeTitular(autorizado.getPersona()) == null) { // control para no autorizar a una persona 
            if (listaAutorizados.isEmpty()) {                       // con el mismo dni que un titular
                this.listaAutorizados.add(autorizado);
                auto = true;
            } else if (this.existePersona(autorizado.getPersona()) == null) {
                this.listaAutorizados.add(autorizado);
                auto = true;
            }
        } else {
            auto = false;
        }
        return auto;
    }

    public boolean nuevoTitular(Persona titular) {
        boolean auto = false;

        if (this.existeTitular(titular) == null) {
            this.listaTitulares.add(titular);
            auto = true;
        }
        return auto;

    }

    public Persona removeTitu(String dni) {
        Persona per = null;

        if (this.listaTitulares.size() != 1) {
            per = this.existeTitular(new Persona(dni));
            if (per != null) {
                this.listaTitulares.remove(per);
            }
        }
        return per;
    }

    public Autorizacion desautorizar(String dni) {
        Autorizacion auto;

        if (!this.listaAutorizados.isEmpty()) {
            auto = this.existePersona(new Persona(dni));
            if (auto != null) {
                this.listaAutorizados.remove(auto);
            }
        } else {
            auto = null;
        }
        return auto;
    }

    public String ingresar(String dni, double cantidad, String descripcion) {
        String niveAuto = "", nivel;
        Autorizacion per;
        Movimiento mov;

        if (this.existeTitular(new Persona(dni)) == null) {
            per = this.existePersona(new Persona(dni)); // me recoge la persona dado el dni
            if (per != null) {
                nivel = per.getNivel();
                switch (nivel) {
                    case "1": // denegado por nivel de autorizacion
                        niveAuto = "1";
                        break;
                    case "2": // todo correcto
                        if (cantidad > 0) {
                            niveAuto = "2";
                            saldo = saldo + cantidad;
                            mov = new Movimiento(dni, cantidad, descripcion);
                            listaMovimientos.add(mov);
                        } else {
                            niveAuto = "3"; // saldo negativo
                        }
                        break;
                }
            } else {
                niveAuto = "0"; // no autorizado en la cuenta
            }
        } else // titular cuenta
        {
            if (cantidad > 0) {
                saldo = saldo + cantidad;
                mov = new Movimiento(dni, cantidad, descripcion);
                listaMovimientos.add(mov);
                niveAuto = "2";
            } else {
                niveAuto = "3";
            }
        }

        return niveAuto;
    }

    public String sacar(String dni, double cantidad, String descripcion) {
        String resultadoOperacion = "", nivel;
        Autorizacion per;
        Movimiento mov;

        if (this.existeTitular(new Persona(dni)) == null) { // si no existe el titular
            per = this.existePersona(new Persona(dni));
            if (per != null) { // si existe la persona
                if (cantidad > 0 && cantidad <= saldo) {
                    nivel = per.getNivel();
                    switch (nivel) {
                        case "1":
                            resultadoOperacion = "1"; // no tiene nivel autorizacion
                            break;
                        case "2":
                            resultadoOperacion = "2"; // todo correcto
                            saldo = saldo - cantidad;
                            mov = new Movimiento(dni, -cantidad, descripcion);
                            listaMovimientos.add(mov);
                            break;
                    }
                } else {
                    resultadoOperacion = "3"; // saldo inferior a lo que pide
                }
            } else {
                resultadoOperacion = "4"; // no autorizado en la cuenta
            }
        } else if (cantidad > 0 && cantidad <= saldo) {
            resultadoOperacion = "2"; // titular
            saldo = saldo - cantidad;
            mov = new Movimiento(dni, -cantidad, descripcion);
            listaMovimientos.add(mov);
        } else {
            resultadoOperacion = "3";
        }
        return resultadoOperacion;
    }

    public String informacionCuenta() {

        String mostrar = "  Nº CUENTA: -> " + numCuenta + " |-- TITULAR:     -> "
                + this.listaTitulares.toString() + " \n            "
                + "         |-- AUTORIZADOS: -> ( "
                + this.listaAutorizados.toString() + "\n SALDO: -> "
                + saldo + " €";
        return mostrar;
    }

    public String mostrarRegistro() {
        String mostrar = "", añadir;

        if (!this.listaMovimientos.isEmpty()) { // si no esta vacia
            for (int i = 0; i < listaMovimientos.size(); i++) {
                añadir = this.listaMovimientos.get(i).toString();
                mostrar = mostrar + "\n" + añadir;
            }
        } else { // si esta vacia
            mostrar = null;
        }
        return mostrar;
    }

    public boolean igual(Long nCuenta) {
        boolean igual = false;
        Long a = this.numCuenta; // lo pongo así pq con long no me deja usar equals
        Long b = nCuenta;
        if (a.equals(b)) {
            igual = true;
        }
        return igual;
    }

    @Override
    public String toString() {
        String resultado = this.numCuenta + "("
                + this.titular.toString() + ")";
        return resultado;
    }

}
