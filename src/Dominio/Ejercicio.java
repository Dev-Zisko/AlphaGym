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
public class Ejercicio {
    public String nombreej;
    public String objetivo;

    public Ejercicio(String nombre, String objetivo) {
        this.nombreej = nombre;
        this.objetivo = objetivo;
    }

    public String getNombreej() {
        return nombreej;
    }

    public void setNombreej(String nombreej) {
        this.nombreej = nombreej;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

}