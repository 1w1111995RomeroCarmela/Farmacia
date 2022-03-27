/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Cobertura {
    
    private int idCobertura;
    private ObraSocial obraSocial;
    private Suministro suministro;
    private float descuento;

    public Cobertura() {
    }

    public Cobertura(int id_cobertura, ObraSocial obraSocial, Suministro idSuministro, float descuento) {
        this.idCobertura = id_cobertura;
        this.obraSocial = obraSocial;
        this.suministro = idSuministro;
        this.descuento = descuento;
    }

    public Cobertura(ObraSocial obraSocial, Suministro idSuministro, float descuento) {
        this.obraSocial = obraSocial;
        this.suministro = idSuministro;
        this.descuento = descuento;
    }

    public int getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(int idCobertura) {
        this.idCobertura = idCobertura;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Suministro getSuministro() {
        return suministro;
    }

    public void setSuministro(Suministro suministro) {
        this.suministro = suministro;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

}
