/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

    
    
public class DTOClientesImporteTotal {
    private String nombreCliente;
    private double montoTotal;

    public DTOClientesImporteTotal() {
    }

    public DTOClientesImporteTotal(String nombreCliente, double montoTotal) {
        this.nombreCliente = nombreCliente;
        this.montoTotal = montoTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
}

