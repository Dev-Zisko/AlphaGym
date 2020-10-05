/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dominio.Deportista;
import Dominio.Ejercicio;
import Dominio.Entrenador;
import Dominio.Especialidad;
import Dominio.Gimnasio;
import Dominio.Persona;
import Interfaz.VentanaPrincipal;
import Persistencia.PersonaXml;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Cursor;
import java.applet.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LAB_A611
 */
public class Controladora {
    JFrame VentanaPrincipal;
    JTextField txtNombreE;
    PersonaXml datos;
    AudioClip sonido;
    Cursor cursor;
    ImageIcon imagenCursor;
    Toolkit TK;
   
    
    public void LlenarListaA (Especialidad esp, ArrayList<Especialidad> aux){
        aux.add(esp);
    }
    
    
    public void LlenarListaA1(Ejercicio eje, ArrayList<Ejercicio>aux1){
        aux1.add(eje);
    }
    
    
    public Controladora(JFrame VentanaPrincipal){
        this.VentanaPrincipal = VentanaPrincipal;
      
    }
    
    
            //Musica
    public void IniciarMusica (){
      sonido = java.applet.Applet.newAudioClip(getClass().getResource("../Musica/musica.wav"));
      sonido.play(); 
       
    }
    
    public void DetenerMusica(){
        sonido.stop();
    }
    
    //Cursor
    public void IniciarCursor (JFrame ventana){    
    imagenCursor = new ImageIcon(getClass().getResource("../Imagenes/Cursor.png"));
    TK = Toolkit.getDefaultToolkit();
    this.cursor = TK.createCustomCursor(imagenCursor.getImage(), new Point(1,1) , "Cursor");
    ventana.setCursor(cursor);
    }
    
    
    public void borrarCampo(JTextField campo, String texto){
        if(campo.getText().equals(texto)){
           campo.setText(null);
        }
    }
    
    
    public void activarPanel(JPanel panelA, JPanel panelB, JPanel panelC, JPanel panelD){
        panelA.setVisible(true);
        panelB.setVisible(false);
        panelC.setVisible(false);
        panelD.setVisible(false);
    }
    
    
    public void salirVentana(JButton boton){
        VentanaPrincipal.dispose();
    } 
    
    
    public void LlenarTabla(PersonaXml datos, JTable TablaE, JTable TablaD, JTextField txtExpE, JTextField textRitCarD, JTextField txtFrecEntrD, JTextField txtTipoEjerD){
        ArrayList<Persona> Lista = datos.todasLasPersonas();
            for (Persona pers : Lista)
            {
                if(pers instanceof Entrenador) {
                   DefaultTableModel dtm = (DefaultTableModel) TablaE.getModel();
                   Entrenador entr = (Entrenador) pers;
                   String[] row = {entr.getNombre(), Integer.toString(entr.getCedula()), Integer.toString(entr.getEdad()), entr.getSexo(), Double.toString(entr.getPeso()), Double.toString(entr.getAltura()), Integer.toString(entr.getExperienciaLaboral()) };
                   dtm.addRow(row);
                   TablaE.setModel(dtm);
                }
            
                if(pers instanceof Deportista){
                   DefaultTableModel dtm = (DefaultTableModel) TablaD.getModel();
                   Deportista depor = (Deportista) pers;
                   String[] row = {depor.getNombre(), Integer.toString(depor.getCedula()), Integer.toString(depor.getEdad()), depor.getSexo(), Double.toString(depor.getPeso()),Double.toString(depor.getAltura()), Integer.toString(depor.getRitmoc()), depor.getFrecuenciaE(), depor.getTipoE() };
                   dtm.addRow(row);
                   TablaD.setModel(dtm); 
                }
            }  
    }
    
    
    public void RestaurarTextfield(JTextField campo, String texto){
        if(campo.getText().equals(""))
           campo.setText(texto);
    }
    
    
    public void inicializarTxtE(JTextField txtNombreE, JTextField txtEdadE, JTextField txtAlturaE, JTextField txtPesoE, JTextField txtExpE, JTextField txtCelE, JTextField txtEsp, JTextField txtHoras){
        txtNombreE.setText("Nombre:");
        txtEdadE.setText("Edad:");
        txtAlturaE.setText("Altura:");
        txtPesoE.setText("Peso:");
        txtExpE.setText("Años de experiencia laboral:");
        txtCelE.setText("Cedula:");
        txtEsp.setText("Especialidad:");
        txtHoras.setText("Horas dictadas:");
    }
    
    
    public void inicializarTxtD(JTextField txtNombreD, JTextField txtEdadD, JTextField txtAlturaD, JTextField txtPesoD, JTextField txtRitCarD, JTextField txtTipoEjerD, JTextField txtEjer, JTextField txtObj, JTextField txtFrecEntrD, JTextField txtCelD){
        txtNombreD.setText("Nombre:");
        txtEdadD.setText("Edad:");
        txtAlturaD.setText("Altura:");
        txtPesoD.setText("Peso:");
        txtRitCarD.setText("Ritmo Cardiaco:");
        txtFrecEntrD.setText("Frecuencia de entrenamiento:");
        txtTipoEjerD.setText("Tipo de ejercicios:");
        txtEjer.setText("Nombre del ejercicio:");
        txtObj.setText("Objetivo del ejercicio:");
        txtCelD.setText("Cedula:");  
    }
    
    
    public void IniciarVentana(JFrame Ventana, String ruta){         
        Ventana.setIconImage(new ImageIcon(getClass().getResource(ruta)).getImage());
    }
    
    
    public double calcularIMC(JTextField txtPeso, JTextField txtAltura, JTextField txtEdad, JComboBox boxSexo){
        double IMC, peso, altura;
        peso = Double.parseDouble(txtPeso.getText());
        altura = Double.parseDouble(txtAltura.getText());
        IMC=peso/Math.pow(altura,2);
        return(IMC);
    }
    
    
    public double calcularPGC(JTextField txtPeso, JTextField txtAltura, JTextField txtEdad, JComboBox boxSexo){
        double pgc, IMC, peso, altura, sex = 0;
        String sexo;
        int edad; 
        edad = Integer.parseInt(txtEdad.getText());
        sexo = (String) boxSexo.getSelectedItem();
        peso = Double.parseDouble(txtPeso.getText());
        altura = Double.parseDouble(txtAltura.getText());
        IMC=peso/Math.pow(altura,2);
            if(sexo.equals("Masculino"))
               sex=1;
            if(sexo.equals("Femenino"))
               sex=0;
        pgc=(1.20*IMC)+(0.23*edad)-(10.8*sex)-(5.4);
        return(pgc);
    }
    
    
    public String determinarGrasa(JComboBox boxSexo, Double pgc){
        double sex = 0;
        String sexo, grasa = null;
        sexo = (String) boxSexo.getSelectedItem();
            if(sexo.equals("Masculino"))
               sex=1;
            if(sexo.equals("Femenino"))
               sex=0;
            if(sex==0 && pgc<15){
               grasa = "Persona con delgadez.";
            }
            if(sex==0 && pgc<25){
               grasa = "Persona delgada.";
            }
            if(sex==0 && pgc>=25 && pgc<=30){
               grasa = "Persona normal.";
            }
            if(sex==0 && pgc>30){
               grasa = "Persona con exceso de grasa.";
            }
            if(sex==1 && pgc<15){
               grasa = "Persona con delgadez.";
            }
            if(sex==1 && pgc<25){
               grasa = "Persona delgada.";
            }
            if(sex==1 && pgc>=15 && pgc<=20){
               grasa = "Persona normal.";
            }
            if(sex==1 && pgc>30){
               grasa = "Persona con exceso de grasa.";
            }
        return(grasa);
    }
    
   
    public void ValidarEntero(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if(((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo debe ingresar números.","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    
    public void ValidarDouble(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if(((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE) && (k !='.')){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo se puede ingresar números o .","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
  
    
    public void ValidarLetras(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if ((k < 97 || k > 122) && (k<65 || k>90) && k!=20 && k!=8 && k!=32 && k!=127){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo debe ingresar letras","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
   
    
    public String determinarRutina(JComboBox boxSexo, Double pgc){
        String grasa, rutina = null, sexo;
        double sex = 0;
        sexo = (String) boxSexo.getSelectedItem();
        grasa = determinarGrasa(boxSexo, pgc);
            if(sexo.equals("Masculino"))
               sex=1;
            if(sexo.equals("Femenino"))
               sex=0;
            if(sex==0 && pgc<25){
               grasa = "Persona delgada.";
            }
            if(sex==0 && grasa.equals("Persona con delgadez."))
               rutina = "Realice una dieta rica en calorias y proteinas.";
            if(sex==0 && grasa.equals("Persona delgada."))
               rutina = "Realice trote de 15 minutos, 50 flexiones y 200 abdominales.";
            if(sex==0 && grasa.equals("Persona normal."))
               rutina = "Rutina cardiovascular y trote de 30 minutos";
            if(sex==0 && grasa.equals("Persona con exceso de grasa."))
               rutina = "Bailoterapia y trote 45 minutos";
            if(sex==1 && grasa.equals("Persona con delgadez."))
               rutina = "Realice una dieta rica en calorias y proteinas.";
            if(sex==1 && grasa.equals("Persona delgada."))
               rutina = "Realice trote de 15 minutos, 50 flexiones y 200 abdominales.";
            if(sex==1 && grasa.equals("Persona normal."))
               rutina = "Levante pesas(30-60kg) y trote de 30 minutos";
            if(sex==1 && grasa.equals("Persona con exceso de grasa."))
               rutina = "Levante pesas(80-120kg) y trote 45 minutos";
        return(rutina);
   }
   
    
    public void eliminarPersona(PersonaXml datos, JTextField txtCel){
        Persona pers = datos.buscarPersona(Integer.parseInt(txtCel.getText()));
            if (pers == null) {
                JOptionPane.showMessageDialog(null, "Pesona no existe.", "Error cédula no encontrada", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Pesona encontrada.");
                int confirmacion = JOptionPane.showOptionDialog(null, "Realmente desea eliminarla?", "::::...Confirmación...:::",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (confirmacion == 0){
                        datos.borrarPersona(Integer.parseInt(txtCel.getText()));
                    }
            }
    }
    
    
    public void traerDatosE(Persona pers, JTextField txtNombreE, JTextField txtEdadE, JTextField txtAlturaE, JTextField txtPesoE, JTextField txtExpE, JTextField txtCelE, JTextField txtEsp, JTextField txtHoras){
        txtNombreE.setText(pers.getNombre());
        txtEdadE.setText(String.valueOf(pers.getEdad()));
        txtAlturaE.setText(String.valueOf(pers.getAltura()));
        txtPesoE.setText(String.valueOf(pers.getPeso()));
        txtExpE.setText("No modificable.");
        txtCelE.setText(String.valueOf(pers.getCedula()));
        txtEsp.setText("No modificable.");
        txtHoras.setText("No modificable.");  
    }
    
    
    public void salvarPersonaE(PersonaXml datos, JTextField txtNombreE, JTextField txtEdadE, JTextField txtAlturaE, JTextField txtPesoE, JTextField txtExpE, JTextField txtCelE, JTextField txtEsp, JTextField txtHoras){
        Persona pers = datos.buscarPersona(Integer.parseInt(txtCelE.getText()));
        pers.setNombre(txtNombreE.getText());
        pers.setEdad(Integer.parseInt(txtEdadE.getText()));
        pers.setAltura(Double.parseDouble(txtAlturaE.getText()));
        pers.setPeso(Double.parseDouble(txtPesoE.getText()));
        datos.actualizarPersona(pers);
    } 
    
    
    public  void activar_desactivarE(boolean verdadFalso,JButton RegistrarE){  
        RegistrarE.setEnabled(verdadFalso);
    }
    
    
    public void modificarEntrenador(PersonaXml datos, JTextField txtCel, JPanel panelA, JPanel panelB, JPanel panelC, JPanel panelD, JTextField txtNombreE, JTextField txtEdadE, JTextField txtAlturaE, JTextField txtPesoE, JTextField txtExpE, JTextField txtCelE, JTextField txtEsp, JTextField txtHoras, JButton RegistrarE, JButton GuardarE){
        Persona pers = datos.buscarPersona(Integer.parseInt(txtCel.getText()));
            if (pers == null) {
                JOptionPane.showMessageDialog(null, "No Existe", "Error cédula no encontrada", JOptionPane.ERROR_MESSAGE);
            } 
            else{ 
                activarPanel(panelA, panelB, panelC, panelD);
                traerDatosE(pers, txtNombreE, txtEdadE, txtAlturaE, txtPesoE, txtExpE, txtCelE, txtEsp, txtHoras);
                activar_desactivarE(false, RegistrarE);
            }
    }
    
    public void traerDatosD(Persona pers, JTextField txtNombreD, JTextField txtEdadD, JTextField txtAlturaD, JTextField txtPesoD, JTextField txtRitCarD, JTextField txtTipoEjerD, JTextField txtEjer, JTextField txtObj, JTextField txtFrecEntrD, JTextField txtCelD){
        txtNombreD.setText(pers.getNombre());
        txtEdadD.setText(String.valueOf(pers.getEdad()));
        txtAlturaD.setText(String.valueOf(pers.getAltura()));
        txtPesoD.setText(String.valueOf(pers.getPeso()));
        txtRitCarD.setText("No modificable.");
        txtCelD.setText(String.valueOf(pers.getCedula()));
        txtTipoEjerD.setText("No modificable.");
        txtEjer.setText("No modificable.");
        txtObj.setText("No modificable.");
        txtFrecEntrD.setText("No modificable.");
    }
    
    
    public void salvarPersonaD(PersonaXml datos, JTextField txtNombreD, JTextField txtEdadD, JTextField txtAlturaD, JTextField txtPesoD, JTextField txtRitCarD, JTextField txtTipoEjerD, JTextField txtEjer, JTextField txtObj, JTextField txtFrecEntrD, JTextField txtCelD){
        Persona pers = datos.buscarPersona(Integer.parseInt(txtCelD.getText()));
        pers.setNombre(txtNombreD.getText());
        pers.setEdad(Integer.parseInt(txtEdadD.getText()));
        pers.setAltura(Double.parseDouble(txtAlturaD.getText()));
        pers.setPeso(Double.parseDouble(txtPesoD.getText())); 
        datos.actualizarPersona(pers);
    } 
    
    
    public  void activar_desactivarD(boolean verdadFalso,JButton RegistrarD){  
        RegistrarD.setEnabled(verdadFalso);
    }
    
    
    public void modificarDeportista(PersonaXml datos, JTextField txtCel, JPanel panelA, JPanel panelB, JPanel panelC, JPanel panelD, JTextField txtNombreD, JTextField txtEdadD, JTextField txtAlturaD, JTextField txtPesoD, JTextField txtRitCarD, JTextField txtTipoEjerD, JTextField txtEjer, JTextField txtObj, JTextField txtFrecEntrD, JTextField txtCelD, JButton RegistrarD, JButton GuardarD){
        Persona pers = datos.buscarPersona(Integer.parseInt(txtCel.getText()));
            if (pers == null) {
                JOptionPane.showMessageDialog(null, "No Existe", "Error cédula no encontrada", JOptionPane.ERROR_MESSAGE);
            } 
            else{ 
                activarPanel(panelA, panelB, panelC, panelD);
                traerDatosD(pers, txtNombreD, txtEdadD, txtAlturaD, txtPesoD, txtRitCarD, txtTipoEjerD, txtEjer, txtObj, txtFrecEntrD, txtCelD);
                activar_desactivarD(false, RegistrarD);
            }
    }
    
    
}  

   
  

    
    
    

