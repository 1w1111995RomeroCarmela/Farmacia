/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author carme
 */


public class DTOFaltanteStock {
    
  private String sucursal;
  private String nombreSuministro;
  private int stock;
  private int stockFaltante;

    public DTOFaltanteStock() {
    }

    public DTOFaltanteStock(String sucursal, String nombreSuministro, int stock, int stockFaltante) {
        this.sucursal = sucursal;
        this.nombreSuministro = nombreSuministro;
        this.stock = stock;
        this.stockFaltante = stockFaltante;
    }

    public DTOFaltanteStock(String nombreSuministro, int stock, int stockFaltante) {
        this.nombreSuministro = nombreSuministro;
        this.stock = stock;
        this.stockFaltante = stockFaltante;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombreSuministro() {
        return nombreSuministro;
    }

    public void setNombreSuministro(String nombreSuministro) {
        this.nombreSuministro = nombreSuministro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockFaltante() {
        return stockFaltante;
    }

    public void setStockFaltante(int stockFaltante) {
        this.stockFaltante = stockFaltante;
    }
  
  
}