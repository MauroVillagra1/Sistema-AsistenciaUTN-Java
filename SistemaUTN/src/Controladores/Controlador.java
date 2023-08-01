/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Alumno;
import Modelo.Comision;
import Modelo.DataBase;
import Modelo.Usuario;
import SISTEMA.SistemaUTN;
import Vista.LoginDB;
import Vista.*;
import Vista.Sistema;
import Vista.Sistema.MiRender;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.ColorType;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit;
import jdk.nashorn.internal.runtime.ScriptObject;
import jtable_a_excel.ExportarExcel;

/**
 *
 * @author Mauro
 */
public class Controlador {

    static Sistema sistema = new Sistema();
    static DataBase db = new DataBase();
    static Login lg = new Login();
    static LoginDB lgDB = new LoginDB();
    static int indice;
    static int PunteroComision;

    public static void ComprobacionBaseDatos() {

    }

    public static void VisibleSistema() {

        sistema.setVisible(true);

    }

    public static void ControladorLoginAutomatico() {
        String PUERTO = "3306";
        String User = "root";
        String Clave = "1234";

        db.ComprobacionBaseDatos(PUERTO, User, Clave);
        CreacionBaseDatos();
        System.out.println(db.isError1());
        System.out.println(db.isError2());
        System.out.println(db.isError3());

        if (db.isError2() == false) {
            VisualLogin();
            LlenarComboBox();
            CargarNombre_Apellido_Sexo();
            CargarAlumno();
            LlenarListaComisiones();
            LlenarTablaComision();
            NotasPerfil();
        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar la base de datos");

        }
    }

    public static void ControladorLoginDB() {
        String PUERTO = lgDB.getjTextField1().getText();
        String User = lgDB.getjTextField2().getText();
        String Clave = lgDB.getjPasswordField1().getText();

        db.ComprobacionBaseDatos(PUERTO, User, Clave);
        CreacionBaseDatos();

        if (db.isError2() == false) {
            VisualLogin();
            LlenarComboBox();
            CargarNombre_Apellido_Sexo();
            CargarAlumno();
            LlenarListaComisiones();
            LlenarTablaComision();
            NotasPerfil();
        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar la base de datos");

        }
    }

    public static void VisualLoginDB() {
        lgDB.setVisible(true);

    }

    public static void Java() {
        {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI(
                            "https://www.java.com/es/");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();

                } catch (URISyntaxException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void MariaDB() {
        {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI(
                            "https://mariadb.org/");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();

                } catch (URISyntaxException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void VisualLogin() {

        lg.setVisible(true);
        lgDB.setVisible(false);

    }

    public static void Login() {
        String contraing = lg.getjPasswordField1().getText();
        String usuarioing = lg.jTextField1.getText();
        String USUARIO = "ISI2022";
        String CONTRASEÑA = "";
        for (Usuario key : db.getNotasIndice()) {
            USUARIO = key.getNombre();
            CONTRASEÑA = key.getContraseña();

        }

        if (contraing.contains(CONTRASEÑA) && usuarioing.contains(USUARIO)) {
            lg.jTextField1.setText(null);
            lg.jPasswordField1.setText(null);
            lg.setVisible(false);
            VisibleSistema();

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR DE INICIO DE SESION", JOptionPane.ERROR_MESSAGE);
            lg.jTextField1.setText(null);
            lg.jPasswordField1.setText(null);

        }

    }

    public static void NotasPerfil() {
        double NotaRegular = 0;
        double NotaPromocion = 0;
        for (Usuario key : db.getNotasIndice()) {
            NotaRegular = key.getRegular();
            NotaPromocion = key.getPromocion();

        }

        if (NotaPromocion == 11) {
            sistema.jLabel64.setText("No Se Puede Promocionar");
        } else {
            sistema.jLabel64.setText(String.valueOf((NotaPromocion)));
        }
        sistema.jLabel63.setText(String.valueOf(NotaRegular));

    }

    public static void ModificarContraseña() {
        String CONTRASEÑA = "";
        for (Usuario key : db.getNotasIndice()) {
            CONTRASEÑA = key.getContraseña();
        }
        String Contraseña2 = sistema.Contraseña2.getText();
        String Contraseña3 = sistema.Contraseña3.getText();
        if (CONTRASEÑA.equals(sistema.Contraseña.getText())) {
            if (Contraseña2.equals(Contraseña3)) {
                db.CambiarContraseña(Contraseña2);
                JOptionPane.showMessageDialog(null, "Contraseña Modificada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseña no coinciden");
                sistema.Contraseña.setText(null);
                sistema.Contraseña2.setText(null);
                sistema.Contraseña3.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las Contraseña es Incorrecta");
        }
        sistema.Contraseña.setText(null);
        sistema.Contraseña2.setText(null);
        sistema.Contraseña3.setText(null);
    }

    public static void CreacionBaseDatos() {
        db.prueba();
        db.CreacionBaseDatos();
    }

    public static void GraficasNota2() {
        if (sistema.jComboBox11.isPopupVisible() == true) {
            String Comision = (String) sistema.jComboBox11.getSelectedItem();
            Graphics lapiz2 = sistema.getjPanel12().getGraphics();
            int i = 0;
            int Aprobado = 0;
            int Regular = 0;
            int Desaprobado = 0;
            double NotaRegular = 0;
            double NotaPromocion = 0;
            for (Usuario key : db.getNotasIndice()) {
                NotaRegular = key.getRegular();
                NotaPromocion = key.getPromocion();

            }

            for (Alumno key : db.getBuscarComision(Comision)) {

                if (key.getNota2() >= NotaRegular && key.getNota1() >= NotaRegular) {
                    if (key.getNota2() >= NotaPromocion && key.getNota1() >= NotaPromocion) {
                        Aprobado++;
                    } else {
                        Regular++;
                    }
                } else {
                    Desaprobado++;
                }

                i++;

            }
            if (i != 0) {
                float PorcentajeAprobado = ((Aprobado * 100) / i);
                sistema.jLabel50.setText(String.valueOf(Aprobado * 100 / i) + "%");
                float PorcentajeRegular = ((Regular * 100) / i);
                sistema.jLabel51.setText(String.valueOf(Regular * 100 / i) + "%");
                float PorcentajeDesaprobado = ((Desaprobado * 100) / i);
                sistema.jLabel52.setText(String.valueOf(Desaprobado * 100 / i) + "%");
                lapiz2.setColor(Color.GREEN);
                lapiz2.fillArc(10, 30, 150, 150, 0, (Aprobado * 360) / i);
                lapiz2.setColor(Color.RED);
                lapiz2.fillArc(10, 30, 150, 150, (Aprobado * 360 / i), (Desaprobado * 360) / i);
                lapiz2.setColor(Color.ORANGE);
                lapiz2.fillArc(10, 30, 150, 150, (Aprobado * 360 / i) + (Desaprobado * 360 / i), (Regular * 360) / i);
            } else {
                sistema.jLabel50.setText("Sin Datos");
                sistema.jLabel51.setText("Sin Datos");
                sistema.jLabel52.setText("Sin Datos");
                lapiz2.setColor(Color.lightGray);
                lapiz2.fillArc(10, 30, 150, 150, 0, 360);
            }

        } else {
            sistema.jLabel50.setText("Sin Datos");
            sistema.jLabel51.setText("Sin Datos");
            sistema.jLabel52.setText("Sin Datos");

        }
    }

    public static void GraficasNota1() {
        if (sistema.jComboBox10.isPopupVisible() == true) {
            String Comision = (String) sistema.jComboBox10.getSelectedItem();
            Graphics lapiz2 = sistema.getjPanel11().getGraphics();
            int i = 0;
            int Aprobado = 0;
            int Regular = 0;
            int Desaprobado = 0;
            double NotaRegular = 0;
            double NotaPromocion = 0;
            for (Usuario key : db.getNotasIndice()) {
                NotaRegular = key.getRegular();
                NotaPromocion = key.getPromocion();

            }

            for (Alumno key : db.getBuscarComision(Comision)) {

                if (key.getNota1() >= NotaRegular) {
                    if (key.getNota1() >= NotaPromocion) {
                        Aprobado++;
                    } else {
                        Regular++;
                    }
                } else {
                    Desaprobado++;
                }

                i++;

            }
            if (i != 0) {
                float PorcentajeAprobado = ((Aprobado * 100) / i);
                sistema.jLabel43.setText(String.valueOf(Aprobado * 100 / i) + "%");
                float PorcentajeRegular = ((Regular * 100) / i);
                sistema.jLabel44.setText(String.valueOf(Regular * 100 / i) + "%");
                float PorcentajeDesaprobado = ((Desaprobado * 100) / i);
                sistema.jLabel45.setText(String.valueOf(Desaprobado * 100 / i) + "%");
                lapiz2.setColor(Color.GREEN);
                lapiz2.fillArc(10, 30, 150, 150, 0, (Aprobado * 360) / i);
                lapiz2.setColor(Color.RED);
                lapiz2.fillArc(10, 30, 150, 150, (Aprobado * 360 / i), (Desaprobado * 360) / i);
                lapiz2.setColor(Color.ORANGE);
                lapiz2.fillArc(10, 30, 150, 150, (Aprobado * 360 / i) + (Desaprobado * 360 / i), (Regular * 360) / i);
            } else {
                sistema.jLabel43.setText("Sin Datos");
                sistema.jLabel44.setText("Sin Datos");
                sistema.jLabel45.setText("Sin Datos");
                lapiz2.setColor(Color.lightGray);
                lapiz2.fillArc(10, 30, 150, 150, 0, 360);
            }

        }
    }

    public static void CambiarNombre() {

        String Nombre = (JOptionPane.showInputDialog("Ingrese su nombre"));

        db.agregarNombre(Nombre);
        CargarNombre_Apellido_Sexo();

    }

    public static void CambiarApellido() {

        String Apellido = (JOptionPane.showInputDialog("Ingrese su Apellido"));

        db.agregarApellido(Apellido);
        CargarNombre_Apellido_Sexo();

    }

    public static void CambiarSexo() {

        if (sistema.jComboBox1.isPopupVisible() == true) {
            String Sexo = (String) sistema.jComboBox1.getSelectedItem();
            db.agregarSexo(Sexo);
            db.agregarSexo(Sexo);
            CargarNombre_Apellido_Sexo();
        }

    }

    public static void NotaRegularizacion() {
        String NotaRegular = (String) sistema.jComboBoxNota1.getSelectedItem();
        db.NotaRegulares(NotaRegular);
    }

    public static void NotaPromocion() {
        String NotaPromocion = (String) sistema.jComboBoxNota2.getSelectedItem();
        if (NotaPromocion.equals("Sin Promocion")) {
            NotaPromocion = "11";
        }
        db.NotaPromociones(NotaPromocion);
    }

    public static void CargarNombre_Apellido_Sexo() {

        db.MostrarNombre_Apellido_SexoDB();
        sistema.jLabel5.setText(db.getUltimoNombre());
        sistema.jLabel7.setText(db.getUltimoApellido());
        sistema.jComboBox1.setSelectedItem(db.getUltimoSexo());
        String Sexo = "Mujer";
        if (db.getUltimoSexo().equals("Mujer")) {
            sistema.imagen_gif_guardar();
        } else {
            sistema.imagen_gif_guardar2();
        }
    }

    public static void LlenarComboBox() {
        //sistema.jComboBox1.removeAllItems();
        sistema.jComboBox1.addItem("Hombre");
        sistema.jComboBox1.addItem("Mujer");

    }

    public static void AgregarAlumnos() {
        int Legajo = Integer.parseInt(sistema.getjTextField1().getText());
        String Nombre = sistema.getjTextField2().getText();
        String Apellido = sistema.getjTextField3().getText();
        String Comision = (String) sistema.jComboBox2.getSelectedItem();

        sistema.getjTextField1().setText(null);
        sistema.getjTextField2().setText(null);
        sistema.getjTextField3().setText(null);

        db.Comprobacion(Legajo);
        if (db.isBandera() == false) {
            db.AgregarAlumno(Legajo, Nombre, Apellido, Comision);

        } else {
            JOptionPane.showMessageDialog(null, "El Legajo Ya Existe");

        }
        CargarAlumno();
        LlenarTablaComision();

    }

    public static void CargarAlumno() {
        DefaultTableModel datos = (DefaultTableModel) sistema.getjTable1().getModel();
        DefaultTableModel datos2 = (DefaultTableModel) sistema.getjTable3().getModel();
        datos.setNumRows(0);
        datos2.setNumRows(0);
        double NotaRegular = 0;
        double NotaPromocion = 0;

        int i=0;
        for (Usuario key : db.getNotasIndice()) {
            NotaRegular = key.getRegular();
            NotaPromocion = key.getPromocion();
        }
        for (Alumno key : db.getAlumno()) {
            Object[] fila = new Object[7];
            fila[0] = key.getLegajo();
            fila[1] = key.getApellido() + " " + key.getNombre();
            fila[2] = key.getComision();
            fila[3] = key.getNota1();
            fila[4] = key.getNota2();

            double NotaFinal = ((key.getNota2() + key.getNota1()) / 2);

            if (key.getNota1() >= NotaRegular && key.getNota2() >= NotaRegular) {
                if (key.getNota1() >= NotaPromocion && key.getNota2() >= NotaPromocion) {
                    
                    fila[5] = "A - " + NotaFinal;
                    fila[6] = "";

                } else {
                    
                    fila[5] = "R - " + NotaFinal;
                    fila[6] = "";
                }
            } else {
                
                fila[5] = "D";
                if (key.getNota1() < NotaRegular && key.getNota2() < NotaRegular) {
                    fila[6] = "Integral";
                } else {
                    if (key.getNota1() < NotaRegular) {
                        fila[6] = "1° Parcial";
                    } else {
                        fila[6] = "2° Parcial";
                    }
                }

            }
            db.NotaFinal(key.getLegajo(), NotaFinal);
i++;
            datos.addRow(fila);
            datos2.addRow(fila);
        }

    }

    public static void EliminarAlumno() {
        int resp = JOptionPane.showConfirmDialog(null, "Los datos del alumno seran borrados PERMANENTEMENTE\n" + "¿Esta seguro?",
                "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp == 0) {
            int Legajo = Integer.parseInt(sistema.getjTextField4().getText());
            String Comision = "";
            for (Alumno key : db.getAlumno()) {
                if (key.getLegajo() == Legajo) {
                    Comision = key.getComision();
                }
            }
            db.EliminarAlumno(Legajo, Comision);

            JOptionPane.showMessageDialog(null, "Alumno eliminado con exito");
            sistema.getjTextField4().setText(null);
            LlenarTablaComision();
            CargarAlumno();
        }
        sistema.getjTextField4().setText(null);

    }

    public static void IngresarNota1() {
        int Legajo = Integer.parseInt(sistema.getjTextField5().getText());
        double Nota1 = Double.parseDouble(sistema.getjTextField6().getText());
        System.out.println(Nota1);
        if (Nota1 >= 0 && Nota1 <= 10) {
            db.IngresarNota1(Legajo, Nota1);
            CargarAlumno();

        } else {
            JOptionPane.showMessageDialog(null, "La Nota debe estar entre 0 y 10");
        }
        sistema.getjTextField5().setText(null);
        sistema.getjTextField6().setText(null);

    }

    public static void IngresarNota2() {
        int Legajo = Integer.parseInt(sistema.getjTextField5().getText());
        double Nota2 = Double.parseDouble(sistema.getjTextField6().getText());
        System.out.println(Nota2);
        if (Nota2 >= 0 && Nota2 <= 10) {
            db.IngresarNota2(Legajo, Nota2);
            CargarAlumno();

        } else {
            JOptionPane.showMessageDialog(null, "La Nota debe estar entre 0 y 10");
        }
        sistema.getjTextField5().setText(null);
        sistema.getjTextField6().setText(null);

    }

    public static void BuscarPorComision() {
        if (sistema.jComboBox3.isPopupVisible() == true) {
            String Comision = (String) sistema.jComboBox3.getSelectedItem();
            db.getBuscarComision(Comision);
            DefaultTableModel datos = (DefaultTableModel) sistema.getjTable1().getModel();
            datos.setNumRows(0);
            for (Alumno key : db.getBuscarComision(Comision)) {
                Object[] fila = new Object[7];
                fila[0] = key.getLegajo();
                fila[1] = key.getApellido() + " " + key.getNombre();
                fila[2] = key.getComision();
                fila[3] = key.getNota1();
                fila[4] = key.getNota2();
                double NotaFinal = ((key.getNota2() + key.getNota1()) / 2);
                fila[5] = NotaFinal;
                db.NotaFinal(key.getLegajo(), NotaFinal);

                datos.addRow(fila);
            }

        }
    }

    public static void LlenarTablaComision() {
        DefaultTableModel datos = (DefaultTableModel) sistema.getjTable4().getModel();
        datos.setNumRows(0);
        for (Comision key : db.getComision()) {
            Object[] fila = new Object[7];

            fila[0] = key.getComision();
            fila[1] = key.getCantidadAlumnos();
            fila[2] = key.getCantidadClases();

            datos.addRow(fila);
        }
    }

    public static void BuscarPorComision2() {
        if (sistema.jComboBox5.isPopupVisible() == true) {
            String Comision = (String) sistema.jComboBox5.getSelectedItem();
            db.getBuscarComision(Comision);
            DefaultTableModel datos = (DefaultTableModel) sistema.getjTable3().getModel();
            datos.setNumRows(0);
            double NotaRegular = 0;
            double NotaPromocion = 0;
            for (Usuario key : db.getNotasIndice()) {
                NotaRegular = key.getRegular();
                NotaPromocion = key.getPromocion();
            }
            for (Alumno key : db.getBuscarComision(Comision)) {
                Object[] fila = new Object[7];
                fila[0] = key.getLegajo();
                fila[1] = key.getApellido() + " " + key.getNombre();
                fila[2] = key.getComision();
                fila[3] = key.getNota1();
                fila[4] = key.getNota2();

                double NotaFinal = ((key.getNota2() + key.getNota1()) / 2);

                if (key.getNota1() >= NotaRegular && key.getNota2() >= NotaRegular) {
                    if (key.getNota1() >= NotaPromocion && key.getNota2() >= NotaPromocion) {
                        sistema.setBackground(Color.YELLOW);

                        fila[5] = "A - " + NotaFinal;
                        fila[6] = "";
                    } else {
                        sistema.setBackground(Color.YELLOW);
                        fila[5] = "R - " + NotaFinal;

                        fila[6] = "";
                    }
                } else {
                    fila[5] = "D";
                    if (key.getNota1() < NotaRegular && key.getNota2() < NotaRegular) {
                    sistema.setBackground(Color.RED);

                        fila[6] = "Integral";
                    } else {
                        if (key.getNota1() < NotaRegular) {
                            fila[6] = "1° Parcial";
                        } else {
                            fila[6] = "2° Parcial";
                        }
                    }

                }
                db.NotaFinal(key.getLegajo(), NotaFinal);

                datos.addRow(fila);
            }

        }
    }

    public static void LlenarListaComisiones() {
        int i = 0;
        sistema.jComboBox2.removeAllItems();
        sistema.jComboBox3.removeAllItems();
        sistema.jComboBox4.removeAllItems();
        sistema.jComboBox5.removeAllItems();
        sistema.jComboBox10.removeAllItems();
        sistema.jComboBox11.removeAllItems();
        sistema.jComboBox13.removeAllItems();

        sistema.jComboBox3.addItem("Todas");
        sistema.jComboBox5.addItem("Todas");
        sistema.jComboBox4.addItem(" ");

        for (Comision key : db.getComision()) {

            sistema.jComboBox6.removeItem(key.getComision());

            sistema.jComboBox2.addItem(key.getComision());
            sistema.jComboBox3.addItem(key.getComision());
            sistema.jComboBox4.addItem(key.getComision());
            sistema.jComboBox5.addItem(key.getComision());
            sistema.jComboBox10.addItem(key.getComision());
            sistema.jComboBox11.addItem(key.getComision());
            sistema.jComboBox13.addItem(key.getComision());
        }

    }

    public static void AgregarComisiones() {

        String Comision = (String) sistema.jComboBox6.getSelectedItem();
        db.AgregarComision(Comision);
        sistema.jComboBox6.removeItem(Comision);
        LlenarListaComisiones();

    }

    public static void EliminarComision() {
        int resp = JOptionPane.showConfirmDialog(null, "Los datos asociados a la Comision seran borrados PERMANENTEMENTE\n" + "¿Esta seguro?",
                "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp == 0) {
            String Comision = (String) sistema.jComboBox13.getSelectedItem();
            db.EliminarComision(Comision);
            sistema.jComboBox6.addItem(Comision);
            LlenarListaComisiones();
            sistema.jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1K1", "1K2", "1K3", "1K4", "1K5", "1K6", "1K7", "1K8", "1K9", "1K10", "2K1", "2K2", "2K3", "2K4", "2K5", "2K6"}));
            LlenarListaComisiones();

        }
    }

    public static void Aux() {
        int aux;
        boolean a;
        String ComisionActual = (String) sistema.getjTable2().getValueAt(0, 2);
        db.CantidadDeClaseComision(ComisionActual);
        for (aux = 0; aux < indice; aux++) {
            if ((boolean) sistema.getjTable2().getValueAt(aux, 4) == true) {
                int LegajoAsistencia = (int) sistema.getjTable2().getValueAt(aux, 0);
                db.CargarAsistencia(LegajoAsistencia);
            }
        }
        String Comision = (String) sistema.jComboBox4.getSelectedItem();
        db.getBuscarComision(Comision);
        DefaultTableModel datos = (DefaultTableModel) sistema.getjTable2().getModel();
        datos.setNumRows(0);
        for (Alumno key : db.getBuscarComision(Comision)) {
            Object[] fila = new Object[5];
            fila[0] = key.getLegajo();
            fila[1] = key.getApellido() + " " + key.getNombre();
            fila[2] = key.getComision();
            fila[3] = key.getAsistencia();

            fila[4] = false;
            datos.addRow(fila);

        }
        LlenarTablaComision();

    }

    public static void Asistencia() {

        if (sistema.jComboBox4.isPopupVisible() == true) {
            indice = 0;
            String Comision = (String) sistema.jComboBox4.getSelectedItem();
            db.getBuscarComision(Comision);
            DefaultTableModel datos = (DefaultTableModel) sistema.getjTable2().getModel();
            datos.setNumRows(0);
            for (Alumno key : db.getBuscarComision(Comision)) {
                Object[] fila = new Object[5];
                fila[0] = key.getLegajo();
                fila[1] = key.getApellido() + " " + key.getNombre();
                fila[2] = key.getComision();
                fila[3] = key.getAsistencia();
                fila[4] = false;
                indice++;
                datos.addRow(fila);

            }
        }
        LlenarTablaComision();

    }

    public static void Excel() {
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(sistema.getjTable3());
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
            System.out.println("786");
        }
    }

}
