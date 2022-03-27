/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class DetalleReceta {
    
    private int idDetalleReceta;
    private int cantidad;
    private float precioFinal;
    private Cobertura cobertura;
    private Receta receta;

    public DetalleReceta() {
    }

    public DetalleReceta(int idDetalleReceta, int cantidad, float precioFinal, Cobertura cobertura, Receta receta) {
        this.idDetalleReceta = idDetalleReceta;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
        this.cobertura = cobertura;
        this.receta = receta;
    }

    public DetalleReceta(int cantidad, float precioFinal, Cobertura cobertura, Receta receta) {
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
        this.cobertura = cobertura;
        this.receta = receta;
    }
    
    

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    
}
