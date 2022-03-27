/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class DTOProfesionalesRecetas {
    private int cantidadRecetas;
    private String profesional;

    public DTOProfesionalesRecetas() {
    }

    public DTOProfesionalesRecetas(int cantidadRecetas, String profesional) {
        this.cantidadRecetas = cantidadRecetas;
        this.profesional = profesional;
    }

    public DTOProfesionalesRecetas(String profesional) {
        this.profesional = profesional;
    }

    public int getCantidadRecetas() {
        return cantidadRecetas;
    }

    public void setCantidadRecetas(int cantidadRecetas) {
        this.cantidadRecetas = cantidadRecetas;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }
    
    
}