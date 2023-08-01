/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mauro
 */
public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Sexo;
    private double Regular;
    private double Promocion;
    private String Usuario;
    private String Contraseña;

    public Usuario() {
    }

    public Usuario(String Nombre, String Apellido, String Sexo, double Regular, double Promocion, String Usuario, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.Regular = Regular;
        this.Promocion = Promocion;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public double getRegular() {
        return Regular;
    }

    public void setRegular(double Regular) {
        this.Regular = Regular;
    }

    public double getPromocion() {
        return Promocion;
    }

    public void setPromocion(double Promocion) {
        this.Promocion = Promocion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
}
