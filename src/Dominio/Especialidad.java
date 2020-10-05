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
public class Especialidad {
    public String nombreesp;
    public int horas;
    

    public Especialidad(String nombreesp, int horas) {
        this.nombreesp = nombreesp;
        this.horas = horas;
    }

    public String getNombreesp() {
        return nombreesp;
    }

    public void setNombreesp(String nombreesp) {
        this.nombreesp = nombreesp;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
}
