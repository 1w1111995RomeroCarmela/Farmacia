
package Models;


public class TipoSuministro {
    
    private int idTipoSuministro;
    private String descripcion;

    public TipoSuministro() {
    }

    public TipoSuministro(int idTipoSuministro, String descripcion) {
        this.idTipoSuministro = idTipoSuministro;
        this.descripcion = descripcion;
    }

    public int getIdTipoSuministro() {
        return idTipoSuministro;
    }

    public void setIdTipoSuministro(int idTipoSuministro) {
        this.idTipoSuministro = idTipoSuministro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
