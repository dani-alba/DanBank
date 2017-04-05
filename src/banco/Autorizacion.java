package banco;

public class Autorizacion {

    private Persona autorizada;
    private String nivel;

    public Autorizacion(Persona autorizada, String nivel) {
        this.autorizada = autorizada;
        this.nivel = nivel;
    }
    
    public Autorizacion(Persona autorizada){
        this.autorizada = autorizada;
    }

    public Persona getPersona() {
        return this.autorizada;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(String nive) {
        this.nivel = nive;
    }

    @Override
    public String toString() {
        String resultado = autorizada.getNombre() + "("
                + autorizada.getNif() + ")" + "["
                + this.nivel + "]";
        return resultado;
    }

}
