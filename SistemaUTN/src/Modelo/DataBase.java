/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controladores.Controlador;
import Vista.*;
import Vista.Sistema;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class DataBase {

    String UltimoNombre;
    String UltimoApellido;
    String UltimoSexo;
    boolean Bandera;
    boolean Error1 = false;
    boolean Error2 = false;
    boolean Error3 = false;
    String Puerto;
    String user;
    String clave;
    String user1 = user;
    String clave1 = clave;
    String URL1 = "jdbc:mariadb://localhost:" + Puerto;
    String URL = "jdbc:mariadb://localhost:" + Puerto + "/basedatosutn";

    public DataBase() {
    }

    public DataBase(boolean Error1, boolean Error2, boolean Error3) {
        this.Error1 = Error1;
        this.Error2 = Error2;
        this.Error3 = Error3;
    }

    public boolean isError1() {
        return Error1;
    }

    public void setError1(boolean Error1) {
        this.Error1 = Error1;
    }

    public boolean isError2() {
        return Error2;
    }

    public void setError2(boolean Error2) {
        this.Error2 = Error2;
    }

    public boolean isError3() {
        return Error3;
    }

    public void setError3(boolean Error3) {
        this.Error3 = Error3;
    }

    public DataBase(boolean Bandera) {
        this.Bandera = Bandera;
    }

    public boolean isBandera() {
        return Bandera;
    }

    public void setBandera(boolean Bandera) {
        this.Bandera = Bandera;
    }

    public String getUltimoNombre() {
        return UltimoNombre;
    }

    public void setUltimoNombre(String UltimoNombre) {
        this.UltimoNombre = UltimoNombre;
    }

    public String getUltimoApellido() {
        return UltimoApellido;
    }

    public void setUltimoApellido(String UltimoApellido) {
        this.UltimoApellido = UltimoApellido;
    }

    public DataBase(String UltimoNombre, String UltimoApellido, String UltimoSexo) {
        this.UltimoNombre = UltimoNombre;
        this.UltimoApellido = UltimoApellido;
        this.UltimoSexo = UltimoSexo;
    }

    public String getUltimoSexo() {
        return UltimoSexo;
    }

    public void setUltimoSexo(String UltimoSexo) {
        this.UltimoSexo = UltimoSexo;
    }

    public DataBase(String UltimoNombre, String UltimoApellido) {
        this.UltimoNombre = UltimoNombre;
        this.UltimoApellido = UltimoApellido;
    }

    static Sistema sistema = new Sistema();

    public Connection getConnection1() throws SQLException {

        return DriverManager.getConnection(URL1, user1, clave1);

    }

    public void ejecutar1(String SQL) {

        try {
            Connection c = getConnection1();
            c.createStatement().execute(SQL);
            Error1 = false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("131");
            Error1 = true;
        }

    }

    public void prueba() {
        String SQL = "CREATE DATABASE `basedatosutn`";
        ejecutar1(SQL);
    }

    public void ComprobacionBaseDatos(String PUERTO, String User, String Clave) {
        Puerto = PUERTO;
        user = User;
        clave = Clave;
        user1 = user;
        clave1 = clave;
        URL1 = "jdbc:mariadb://localhost:" + Puerto;
        URL = "jdbc:mariadb://localhost:" + Puerto + "/basedatosutn";
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, user, clave);

    }

    public void ejecutar(String SQL) {

        try {
            Connection c = getConnection();
            c.createStatement().execute(SQL);
            c.close();
            Error2 = false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("166");
            Error2 = true;

        }

    }

    public void CreacionBaseDatos() {
        String SQL = "CREATE DATABASE `basedatosutn`";
        ejecutar(SQL);
        SQL = "CREATE TABLE `alumnos` (\n"
                + "	`Codigo` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "	`Legajo` INT(11) NULL DEFAULT NULL,\n"
                + "	`Nombre` VARCHAR(50) NULL DEFAULT NULL,\n"
                + "	`Apellido` VARCHAR(50) NULL DEFAULT NULL,\n"
                + "	`Comision` VARCHAR(50) NULL DEFAULT NULL,\n"
                + "	`Nota1` DOUBLE NULL DEFAULT NULL,\n"
                + "	`Nota2` DOUBLE NULL DEFAULT NULL,\n"
                + "	`Asistencia` INT(11) NULL DEFAULT NULL,\n"
                + "	`NotaFinal` VARCHAR(50) NULL DEFAULT NULL,\n"
                + "	PRIMARY KEY (`Codigo`)\n"
                + ")\n"
                + "COLLATE='utf8_general_ci'\n"
                + "ENGINE=InnoDB\n"
                + "AUTO_INCREMENT=72\n"
                + ";";
        ejecutar(SQL);

        SQL = "CREATE TABLE `clasescomisiones` (\n"
                + "	`Codigo` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "	`Comision` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`CantidadAlumnos` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`CantidadClases` INT(11) NULL DEFAULT NULL,\n"
                + "	PRIMARY KEY (`Codigo`) USING BTREE\n"
                + ")\n"
                + "COLLATE='utf8_general_ci'\n"
                + "ENGINE=InnoDB\n"
                + "AUTO_INCREMENT=172\n"
                + ";";
        ejecutar(SQL);

        SQL = "CREATE TABLE `nombre_apellido` (\n"
                + "	`Codigo` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "	`Nombre` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`Apellido` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`Sexo` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`Regular` DOUBLE NULL DEFAULT NULL,\n"
                + "	`Promocion` DOUBLE NULL DEFAULT NULL,\n"
                + "	`Usuario` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	`Contraseña` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',\n"
                + "	PRIMARY KEY (`Codigo`) USING BTREE\n"
                + ")\n"
                + "COLLATE='utf8_general_ci'\n"
                + "ENGINE=InnoDB\n"
                + "AUTO_INCREMENT=11\n"
                + ";";
        ejecutar(SQL);
        SQL = "INSERT INTO `basedatosutn`.`nombre_apellido` (`Contraseña`, `Codigo`, `Usuario`, `Sexo`) VALUES ('', '1', '', 'Hombre');";
        ejecutar(SQL);

        SQL = "DELETE FROM nombre_apellido WHERE Codigo != '1'";
        ejecutar(SQL);

    }

    public void agregarNombre(String Nombre) {

        String SQL = "insert into nombre_apellido(Nombre, Apellido, Sexo) values ('%1', '%2', '%3')";
        SQL = "UPDATE nombre_apellido SET Nombre = ('%1')  WHERE Codigo = '1'";
        SQL = SQL.replace("%1", Nombre);
        ejecutar(SQL);
        /*SQL = "CREATE TABLE `PETE` (\n" +
"	`Codigo` INT(11) NOT NULL AUTO_INCREMENT,\n" +
"	`Legajo` INT(11) NULL DEFAULT NULL,\n" +
"	`Nombre` VARCHAR(50) NULL DEFAULT NULL,\n" +
"	`Apellido` VARCHAR(50) NULL DEFAULT NULL,\n" +
"	`Comision` VARCHAR(50) NULL DEFAULT NULL,\n" +
"	`Nota1` DOUBLE NULL DEFAULT NULL,\n" +
"	`Nota2` DOUBLE NULL DEFAULT NULL,\n" +
"	`Asistencia` INT(11) NULL DEFAULT NULL,\n" +
"	`NotaFinal` VARCHAR(50) NULL DEFAULT NULL,\n" +
"	PRIMARY KEY (`Codigo`)\n" +
")\n" +
"COLLATE='utf8_general_ci'\n" +
"ENGINE=InnoDB\n" +
"AUTO_INCREMENT=72\n" +
";";*/

    }

    public void agregarApellido(String Apellido) {

        String SQL = "insert into nombre_apellido(Nombre, Apellido, Sexo) values ('%1', '%2', '%3')";
        SQL = "UPDATE nombre_apellido SET Apellido = '%2'  WHERE Codigo = '1'";
        SQL = SQL.replace("%2", Apellido);
        ejecutar(SQL);
    }

    public void agregarSexo(String Sexo) {

        String SQL = "insert into nombre_apellido(Nombre, Apellido, Sexo) values ('%1', '%2', '%3')";
        SQL = "UPDATE nombre_apellido SET Sexo = '%3'  WHERE Codigo = '1'";
        SQL = SQL.replace("%3", Sexo);
        ejecutar(SQL);
    }

    public void NotaRegulares(String NotaRegular) {

        String SQL = "insert into nombre_apellido(Nombre, Apellido, Sexo, Regular, Promocion) values ('%1', '%2', '%3', '%4', '%5')";
        SQL = "UPDATE nombre_apellido SET Regular = '%2'  WHERE Codigo = '1'";
        SQL = SQL.replace("%2", NotaRegular);
        ejecutar(SQL);
    }

    public void NotaPromociones(String NotaPromocion) {

        String SQL = "insert into nombre_apellido(Nombre, Apellido, Sexo, Regular, Promocion) values ('%1', '%2', '%3', '%4', '%5')";
        SQL = "UPDATE nombre_apellido SET Promocion = '%2'  WHERE Codigo = '1'";
        SQL = SQL.replace("%2", NotaPromocion);
        ejecutar(SQL);
    }

    public void MostrarNombre_Apellido_SexoDB() {

        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from nombre_apellido");
            while (res.next()) {

                if (res.isLast()) {

                    UltimoNombre = res.getString("Nombre");
                    UltimoApellido = res.getString("Apellido");
                    UltimoSexo = res.getString("Sexo");

                }
            }
            res.close();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("307");
            
        }

    }

// Registro Alumnos -------------------------------------------------------------
    public void AgregarAlumno(int Legajo, String Nombre, String Apellido, String Comision) {
        String SQL = "insert into alumnos(Legajo, Nombre, Apellido, Comision, Nota1, Nota2, "
                + "Asistencia, NotaFinal) values ('%1', '%2', '%3', '%4', '%5', '%6', '%7', '%8')";
        SQL = SQL.replace("%1", String.valueOf(Legajo));
        SQL = SQL.replace("%2", String.valueOf(Nombre));
        SQL = SQL.replace("%3", String.valueOf(Apellido));
        SQL = SQL.replace("%4", Comision);
        SQL = SQL.replace("%5", String.valueOf(0));
        SQL = SQL.replace("%6", String.valueOf(0));
        SQL = SQL.replace("%7", String.valueOf(0));
        SQL = SQL.replace("%8", "Sin Nota");
        ejecutar(SQL);
        SQL = "Select *FROM clasescomisiones";
        SQL = "UPDATE clasescomisiones SET CantidadAlumnos = CantidadAlumnos+1 WHERE Comision = '%9'";
        SQL = SQL.replace("%9", Comision);
        ejecutar(SQL);

    }

    public void EliminarAlumno(int Legajo, String Comision) {
        String SQL = "DELETE FROM alumnos WHERE Legajo = '%1' ";
        SQL = SQL.replace("%1", String.valueOf(Legajo));

        ejecutar(SQL);
        SQL = "Select *FROM clasescomisiones";
        SQL = "UPDATE clasescomisiones SET CantidadAlumnos = CantidadAlumnos-1 WHERE Comision = '%2'";
        SQL = SQL.replace("%2", Comision);
        ejecutar(SQL);
    }

    public void IngresarNota1(int Legajo, double Nota1) {
        String SQL = "Select * from alumnos ORDER BY Apellido ASC";
        SQL = "UPDATE alumnos SET Nota1 = '%2' WHERE Legajo = '%1'";
        SQL = SQL.replace("%1", String.valueOf(Legajo));
        SQL = SQL.replace("%2", String.valueOf(Nota1));
        ejecutar(SQL);

    }

    public void IngresarNota2(int Legajo, double Nota2) {
        String SQL = "Select * from alumnos ORDER BY Apellido ASC";
        SQL = "UPDATE alumnos SET Nota2 = '%2' WHERE Legajo = '%1'";
        SQL = SQL.replace("%1", String.valueOf(Legajo));
        SQL = SQL.replace("%2", String.valueOf(Nota2));
        ejecutar(SQL);

    }

    public void BuscarComision(String Comision) {
        String SQL = "SELECT *FROM alumnos WHERE Comision = '%1'";
        SQL = SQL.replace("%1", Comision);
        ejecutar(SQL);

    }

    public void CargarAsistencia(int LegajoAsistencia) {
        String SQL = "Select * from alumnos ORDER BY Apellido ASC";
        SQL = "UPDATE alumnos SET Asistencia = Asistencia+1 WHERE Legajo = '%1'";
        SQL = SQL.replace("%1", String.valueOf(LegajoAsistencia));
        ejecutar(SQL);

    }

    public void NotaFinal(int Legajo, double NotaFinal) {
        String SQL = "Select * from alumnos ORDER BY Apellido ASC";
        SQL = "UPDATE alumnos SET NotaFinal = '%2' WHERE Legajo = '%1'";
        SQL = SQL.replace("%1", String.valueOf(Legajo));
        SQL = SQL.replace("%2", String.valueOf(NotaFinal));
        ejecutar(SQL);
    }

    public void AgregarComision(String Comision) {
        String SQL = "insert into clasescomisiones(Comision, CantidadAlumnos, CantidadClases) values ('%1', '%2', '%3')";
        SQL = SQL.replace("%1", Comision);
        SQL = SQL.replace("%2", String.valueOf(0));
        SQL = SQL.replace("%3", "0");
        ejecutar(SQL);
    }

    public void EliminarComision(String Comision) {
        String SQL = "DELETE FROM clasescomisiones WHERE Comision = '%1'";
        SQL = SQL.replace("%1", Comision);
        ejecutar(SQL);
        SQL = "delete FROM alumnos WHERE Comision = '%2'";
        SQL = SQL.replace("%2", Comision);
        ejecutar(SQL);
    }

    public void CantidadDeClaseComision(String ComisionActual) {
        String SQL = "SELECT *FROM clasescomisiones";
        SQL = "UPDATE clasescomisiones SET CantidadClases = CantidadClases+1 WHERE Comision = '%1'";
        SQL = SQL.replace("%1", ComisionActual);
        ejecutar(SQL);

    }

    public void CambiarContraseña(String Contraseña) {
        String SQL = "insert into nombre_apellido(Contraseña) values ('%1')";
        SQL = "UPDATE nombre_apellido SET Contraseña = '%2'  WHERE Codigo = '1'";
        SQL = SQL.replace("%2", Contraseña);
        ejecutar(SQL);
    }

    public void CambiarUsuario(String Usuario) {
        String SQL = "insert into nombre_apellido(Usuario) values ('%1')";
        SQL = "UPDATE nombre_apellido SET Usuario = '%2'  WHERE Codigo = '1'";
        SQL = SQL.replace("%2", Usuario);
        ejecutar(SQL);
    }

    public ArrayList<Alumno> getBuscarComision(String Comision) {

        ArrayList<Alumno> comision = new ArrayList<>();

        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from alumnos ORDER BY Apellido ASC");
            while (res.next()) {
                Alumno key = new Alumno();
                if (Comision.equals(res.getString("Comision"))) {

                    key.setLegajo(res.getInt("Legajo"));
                    key.setNombre(res.getString("Nombre"));
                    key.setApellido(res.getString("Apellido"));
                    key.setComision(res.getString("Comision"));
                    key.setNota1(res.getDouble("Nota1"));
                    key.setNota2(res.getDouble("Nota2"));
                    key.setAsistencia(res.getInt("Asistencia"));
                    key.setNotaFinal(res.getString("NotaFinal"));
                    comision.add(key);

                }
                if (Comision.equals("Todas")) {
                    key.setLegajo(res.getInt("Legajo"));
                    key.setNombre(res.getString("Nombre"));
                    key.setApellido(res.getString("Apellido"));
                    key.setComision(res.getString("Comision"));
                    key.setNota1(res.getDouble("Nota1"));
                    key.setNota2(res.getDouble("Nota2"));
                    key.setAsistencia(res.getInt("Asistencia"));
                    key.setNotaFinal(res.getString("NotaFinal"));
                    comision.add(key);
                }

            }
            res.close();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("462");

        }

        return comision;
    }

    public ArrayList<Alumno> getAlumno() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from alumnos ORDER BY Apellido ASC");
            while (res.next()) {

                Alumno key = new Alumno();
                key.setLegajo(res.getInt("Legajo"));
                key.setNombre(res.getString("Nombre"));
                key.setApellido(res.getString("Apellido"));
                key.setComision(res.getString("Comision"));
                key.setNota1(res.getDouble("Nota1"));
                key.setNota2(res.getDouble("Nota2"));
                key.setAsistencia(res.getInt("Asistencia"));
                key.setNotaFinal(res.getString("NotaFinal"));
                alumnos.add(key);
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("5");
            Controlador.ControladorLoginAutomatico();

        }

        return alumnos;
    }

    public void Comprobacion(int Legajo) {
        Bandera = false;
        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from alumnos ORDER BY Apellido ASC");
            while (res.next()) {
                if (Legajo == res.getInt("Legajo")) {
                    Bandera = true;

                }

            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("6");

        }

    }

    public ArrayList<Usuario> getNotasIndice() {
        ArrayList<Usuario> nota = new ArrayList<>();
        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from nombre_apellido");
            while (res.next()) {

                Usuario key = new Usuario();
                key.setRegular(res.getDouble("Regular"));
                key.setPromocion(res.getDouble("Promocion"));
                key.setNombre(res.getString("Usuario"));
                key.setContraseña(res.getString("Contraseña"));
                nota.add(key);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("7");

        }

        return nota;
    }

    public ArrayList<Comision> getComision() {

        ArrayList<Comision> comision = new ArrayList<>();

        try {
            Connection c = getConnection();
            ResultSet res = c.createStatement().executeQuery("Select * from clasescomisiones ORDER BY Comision ASC ");
            while (res.next()) {

                Comision key = new Comision();
                key.setComision(res.getString("Comision"));
                key.setCantidadAlumnos(res.getInt("CantidadAlumnos"));
                key.setCantidadClases(res.getInt("CantidadClases"));
                comision.add(key);
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("8");

        }

        return comision;
    }

}
