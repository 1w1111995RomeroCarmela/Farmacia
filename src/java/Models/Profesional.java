/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Profesional {
    
    private int idProfesional;
    private int matricula;
    private String nombre;
    private String Apellido;

    public Profesional() {
    }

    public Profesional(int idProfesional, int matricula, String nombre, String Apellido) {
        this.idProfesional = idProfesional;
        this.matricula = matricula;
        this.nombre = nombre;
        this.Apellido = Apellido;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
}
