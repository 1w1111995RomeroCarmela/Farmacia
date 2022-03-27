package DTO;

public class DTODetalle {

    private int idDetalleReceta;
    private int idReceta;
    private int cantidad;
    private String nombSuministro;
    private boolean esVentaLibre;
    private float precOriginal;
    private String obraSocial;
    private float descCobertura;
    private float precFinal;

    public DTODetalle() {
    }

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombSuministro() {
        return nombSuministro;
    }

    public void setNombSuministro(String nombSuministro) {
        this.nombSuministro = nombSuministro;
    }

    public boolean isEsVentaLibre() {
        return esVentaLibre;
    }

    public void setEsVentaLibre(boolean esVentaLibre) {
        this.esVentaLibre = esVentaLibre;
    }

    public float getPrecOriginal() {
        return precOriginal;
    }

    public void setPrecOriginal(float precOriginal) {
        this.precOriginal = precOriginal;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public float getDescCobertura() {
        return descCobertura;
    }

    public void setDescCobertura(float descCobertura) {
        this.descCobertura = descCobertura;
    }

    public float getPrecFinal() {
        return precFinal;
    }

    public void setPrecFinal(float precFinal) {
        this.precFinal = precFinal;
    }

}