package DTO;

public class DTOSuministro {
     private int idSuministro;
    private String nombre;
    private float precio;
    private int stock;
    private boolean esVentaLibre;
    private String tipoSuministro;
    private String sucursal;

    public int getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(int idSuministro) {
        this.idSuministro = idSuministro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEsVentaLibre() {
        return esVentaLibre;
    }

    public void setEsVentaLibre(boolean esVentaLibre) {
        this.esVentaLibre = esVentaLibre;
    }

    public String getTipoSuministro() {
        return tipoSuministro;
    }

    public void setTipoSuministro(String tipoSuministro) {
        this.tipoSuministro = tipoSuministro;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
