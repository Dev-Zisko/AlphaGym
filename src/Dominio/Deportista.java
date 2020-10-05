/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LAB_A611
 */
public class Deportista extends Persona {

    public int ritmoc;
    public String frecuenciaE;
    public String tipoE;
    public ArrayList<Ejercicio> ejercicios;
    private int cantidadEjercicios;
    String tipo;

    public Deportista(String tipo, int ritmoc, String frecuenciaE, String tipoE, int cantidadEjercicios, int cedula, String nombre, int edad, String sexo, double peso, double altura, String direccion) {
        super(cedula, nombre, edad, sexo, peso, altura, direccion);
        this.tipo = tipo;
        this.ritmoc = ritmoc;
        this.frecuenciaE = frecuenciaE;
        this.tipoE = tipoE;
        //this.ejercicios = ejercicios;
        this.cantidadEjercicios = cantidadEjercicios;
    }

    public int getRitmoc() {
        return ritmoc;
    }

    public void setRitmoc(int ritmoc) {
        this.ritmoc = ritmoc;
    }

    public String getFrecuenciaE() {
        return frecuenciaE;
    }

    public void setFrecuenciaE(String frecuenciaE) {
        this.frecuenciaE = frecuenciaE;
    }

    public String getTipoE() {
        return tipoE;
    }

    public void setTipoE(String tipoE) {
        this.tipoE = tipoE;
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public int getCantidadEjercicios() {
        return cantidadEjercicios;
    }

    public void setCantidadEjercicios(int cantidadEjercicios) {
        this.cantidadEjercicios = cantidadEjercicios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
         
    @Override
    public int calcularIMC(double peso, double altura, int edad, char sexo){
     double pgc, sex = 0; 
     double IMC;
     IMC=peso/Math.pow(altura,2);
     if(sexo=='m' && sexo=='M')
         sex=1;
     if(sexo=='f' && sexo=='F')
         sex=0;
   
     pgc=(1.20*IMC)+(0.23*edad)-(10.8*sex)-(5.4);
     if(sex==0 && pgc<25){
         System.out.println("se considera Delgada.");
       }
     if(sex==0 && pgc>=25 && pgc<=30){
         System.out.println("Es normal.");
     }
     if(sex==0 && pgc>30){
         System.out.println("Exceso de grasa.");
     }
     if(sex==1 && pgc<15){
         System.out.println("Delgadez.");
     }
     if(sex==1 && pgc>=15 && pgc<=20){
         System.out.println("Es normal.");
     }
     if(sex==1 && pgc>30){
         System.out.println("Exceso de grasa.");
     }
     return(int) (pgc);//Verificar
     } 
     void verificarRitmo(int ritmoc){
         if(ritmoc>100){
             System.out.println("Se recomienda no realizar entrenamiento hoy.");
         }
     }
}

    
    
    