/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mauro
 */
public class Comision {
    private String Comision;
    private int CantidadAlumnos;
    private int CantidadClases;

    public Comision() {
    }

    public Comision(String Comision, int CantidadAlumnos, int CantidadClases) {
        this.Comision = Comision;
        this.CantidadAlumnos = CantidadAlumnos;
        this.CantidadClases = CantidadClases;
    }

    public String getComision() {
        return Comision;
    }

    public void setComision(String Comision) {
        this.Comision = Comision;
    }

    public int getCantidadAlumnos() {
        return CantidadAlumnos;
    }

    public void setCantidadAlumnos(int CantidadAlumnos) {
        this.CantidadAlumnos = CantidadAlumnos;
    }

    public int getCantidadClases() {
        return CantidadClases;
    }

    public void setCantidadClases(int CantidadClases) {
        this.CantidadClases = CantidadClases;
    }
    
}
