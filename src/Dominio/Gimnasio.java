/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;

/**
 *
 * @author LAB_A611
 */
public class Gimnasio {
    
    private ArrayList<Persona> personas;
    public String nombre;
    public double tarifaIns;
    public double montoMen;
    private int cantidadPersonas;

    public Gimnasio(String nombre, double tarifaIns, double montoMen) {
        this.nombre = nombre;
        this.tarifaIns = tarifaIns;
        this.montoMen = montoMen;
        cantidadPersonas=0;
    }
    
    

    public Gimnasio() {
        this.personas = new ArrayList<Persona>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void incluirPersona(Persona P) {
        personas.add(P);

    }
    
    
}
