package banco;

public class Persona {

    private String nif;
    private String nombre;

    public Persona(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }
    
    public Persona(String nif){
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean igual(Persona p) {
        return this.nif.equalsIgnoreCase(p.nif);
    }

    @Override
    public String toString() {
        String resultado = nombre + "(" + nif + ")";
        return resultado;
    }
}
