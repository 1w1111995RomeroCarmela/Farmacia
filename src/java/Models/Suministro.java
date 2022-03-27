
package Models;

/**
 *
 * @author carme
 */
public class Suministro {
    
    private int idSuministro;
    private String nombre;
    private float precio;
    private int stock;
    private boolean esVentaLibre;
    private TipoSuministro tipoSuministro;
    private Sucursal sucursal;

    public Suministro() {
    }

    public Suministro(String nombre, float precio, int stock, boolean esVentaLibre, TipoSuministro tipoSuministro, Sucursal sucursal) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.esVentaLibre = esVentaLibre;
        this.tipoSuministro = tipoSuministro;
        this.sucursal = sucursal;
    }

    public Suministro(int idSuministro, String nombre, float precio, int stock, boolean esVentaLibre, TipoSuministro tipoSuministro, Sucursal sucursal) {
        this.idSuministro = idSuministro;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.esVentaLibre = esVentaLibre;
        this.tipoSuministro = tipoSuministro;
        this.sucursal = sucursal;
    }

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

    public TipoSuministro getTipoSuministro() {
        return tipoSuministro;
    }

    public void setTipoSuministro(TipoSuministro tipoSuministro) {
        this.tipoSuministro = tipoSuministro;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    
    
}
