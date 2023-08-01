/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mauro
 */
public class Alumno {
    private int Legajo;
    private String Nombre;
    private String Apellido;
    private String Comision;
    private double Nota1;
    private double Nota2;
    private int Asistencia;
    private String NotaFinal;

    public Alumno() {
    }

    public Alumno(String NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    public Alumno(int Legajo, String Nombre, String Apellido, String Comision, double Nota1, double Nota2, int Asistencia) {
        this.Legajo = Legajo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Comision = Comision;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Asistencia = Asistencia;
    }

    public int getAsistencia() {
        return Asistencia;
    }

    public String getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(String NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    public int getLegajo() {
        return Legajo;
    }

    public void setLegajo(int Legajo) {
        this.Legajo = Legajo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getComision() {
        return Comision;
    }

    public void setComision(String Comision) {
        this.Comision = Comision;
    }

    public double getNota1() {
        return Nota1;
    }

    public void setNota1(double Nota1) {
        this.Nota1 = Nota1;
    }

    public double getNota2() {
        return Nota2;
    }

    public void setNota2(double Nota2) {
        this.Nota2 = Nota2;
    }

    public int isAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(int Asistencia) {
        this.Asistencia = Asistencia;
    }
    
    
    
}
    