
package DTO;


public class DTOCobertura {
    
    private int idCobertura;
    private String nombreObraSocial;
    private String nombreSuministro;
    private float descuento;
    private float precioLista;

    public DTOCobertura() {
    }

    public DTOCobertura(int idCobertura, String nombreObraSocial, String nombreSuministro, float descuento, float precioLista) {
        this.idCobertura = idCobertura;
        this.nombreObraSocial = nombreObraSocial;
        this.nombreSuministro = nombreSuministro;
        this.descuento = descuento;
        this.precioLista = precioLista;
    }

    public int getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(int idCobertura) {
        this.idCobertura = idCobertura;
    }

    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }

    public String getNombreSuministro() {
        return nombreSuministro;
    }

    public void setNombreSuministro(String nombreSuministro) {
        this.nombreSuministro = nombreSuministro;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

  

   
    
}
