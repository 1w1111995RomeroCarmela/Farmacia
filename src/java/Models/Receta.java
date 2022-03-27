
package Models;

public class Receta {
    
    private int idReceta;
    private Cliente cliente;
    private ObraSocial obraSocial;
    private Profesional profesional;
    private Sucursal sucursal;

    public Receta() {
    }

    public Receta(Cliente cliente, ObraSocial obraSocial, Profesional profesional, Sucursal sucursal) {
        this.cliente = cliente;
        this.obraSocial = obraSocial;
        this.profesional = profesional;
        this.sucursal = sucursal;
    }

    public Receta(int idReceta, Cliente cliente, ObraSocial obraSocial, Profesional profesional, Sucursal sucursal) {
        this.idReceta = idReceta;
        this.cliente = cliente;
        this.obraSocial = obraSocial;
        this.profesional = profesional;
        this.sucursal = sucursal;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
