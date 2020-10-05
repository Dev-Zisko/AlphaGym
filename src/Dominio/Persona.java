/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;



/**
 *
 * @author LAB_A611
 */
public abstract class Persona {
    
    private int cedula;
    public String nombre;
    public int edad;
    public String sexo;
    public double peso;
    public double altura;
    private String direccion;

    public Persona() {
        cedula=0;
        nombre="";
        edad=0;
        sexo="";
        peso=0;
        altura=0;
        direccion="";
    }

    public Persona(int cedula, String nombre, int edad, String sexo, double peso, double altura, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   public abstract int calcularIMC(double peso, double altura, int edad, char sexo);
     
}

   
   
