
package DTO;

public class DTOTotalRecetasSucursal {
    
    private int cantidadRecetas;
    private float montoCliente;
    private float montoObrasSociales;
    private String nombre;
    private String sucursal;

    public DTOTotalRecetasSucursal() {
    }

    public DTOTotalRecetasSucursal(int cantidadRecetas, float montoCliente, float montoObrasSociales, String nombre, String sucursal) {
        this.cantidadRecetas = cantidadRecetas;
        this.montoCliente = montoCliente;
        this.montoObrasSociales = montoObrasSociales;
        this.nombre = nombre;
        this.sucursal = sucursal;
    }

    public int getCantidadRecetas() {
        return cantidadRecetas;
    }

    public void setCantidadRecetas(int cantidadRecetas) {
        this.cantidadRecetas = cantidadRecetas;
    }

    public float getMontoCliente() {
        return montoCliente;
    }

    public void setMontoCliente(float montoCliente) {
        this.montoCliente = montoCliente;
    }

    public float getMontoObrasSociales() {
        return montoObrasSociales;
    }

    public void setMontoObrasSociales(float montoObrasSociales) {
        this.montoObrasSociales = montoObrasSociales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
