package banco;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Banco {

    public String nombreBanco;
    public long numCuen = 1000;
    public Map<Long, CuentaBancaria> listaCuentas = new HashMap<>();

    public Long numCuenAsig() {
        return numCuen++;
    }

    public Banco(String nomBanco) {
        this.nombreBanco = nomBanco;
    }

    public String getNomBanco() {
        return this.nombreBanco;
    }

    public void setBanco(String nomBanco) {
        this.nombreBanco = nomBanco;
    }

    public Map getListaCuentas() {
        return this.listaCuentas;
    }

    public CuentaBancaria buscCuent(long numCuenta) {
        CuentaBancaria devolver = null;

        if (this.existe(numCuenta) != null) {
            devolver = this.listaCuentas.get(numCuenta);
        }

        return devolver;
    }

    public CuentaBancaria existe(Long nCuenta) {
        return this.listaCuentas.get(nCuenta);
    }

    public boolean setNombreTitular(Long numCuenta, String dni, String nombre) {
        Persona tituCuent, temp;
        temp = new Persona(dni, "");

        tituCuent = this.listaCuentas.get(numCuenta).existeTitular(temp);
        tituCuent.setNombre(nombre);

        return true;
    }

    public boolean setNifTitular(Long numCuenta, String oldDni, String newDni) {
        Persona tituCuent, temp;
        temp = new Persona(oldDni, "");

        tituCuent = this.listaCuentas.get(numCuenta).existeTitular(temp);
        tituCuent.setNif(newDni);

        return true;
    }

    public Long getNumCuenta() {
        return this.numCuen;
    }

    public boolean crearCuenta(CuentaBancaria cuentaNueva) {
        boolean crear = false;
        Long num = cuentaNueva.getNumCuenta();

        if (listaCuentas.isEmpty()) {
            listaCuentas.put(num, cuentaNueva);
            crear = true;
        } else if (this.existe(num) == null) {
            listaCuentas.put(num, cuentaNueva);
            crear = true;
        }
        return crear;
    }

    public boolean eliminarCuenta(Long nCuent) {

        boolean eliminar = false;

        if (this.existe(nCuent) != null) {
            this.listaCuentas.remove(nCuent);
            eliminar = true;
        }
        return eliminar;
    }

    @Override
    public String toString() {
        String mostrar = "", añadir;

        CuentaBancaria cuenta = null;
        long nCuenta;

        Iterator<Long> it = listaCuentas.keySet().iterator();
        while (it.hasNext()) {
            nCuenta = it.next();
            cuenta = this.listaCuentas.get(nCuenta);
            añadir = " CUENTA Nº -> " + nCuenta
                    + "--- INF. ---> " + cuenta.getListaTitulares().toString();
            mostrar = mostrar + "\n" + añadir;
        }
        return mostrar;
    }
}
