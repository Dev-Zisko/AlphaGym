/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
   
import java.util.ArrayList;

    public class Entrenador extends Persona {
     
    public int experienciaLaboral;
    private ArrayList<Especialidad> especialidades;
    public int cantidadEspecialidades;
    public String tipo;
    
        public Entrenador(String tipo,int experienciaLaboral, int cedula, String nombre, int edad, String sexo, double peso, double altura, String direccion) {
        super(cedula, nombre, edad, sexo, peso, altura, direccion);
        this.tipo = tipo;
        this.experienciaLaboral = experienciaLaboral;
    }
    
        public Entrenador() {
        this.especialidades = new ArrayList<Especialidad>();
    }



    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void incluirEspecialidad(Especialidad E) {
        especialidades.add(E);

    }

    public int getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(int experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public int getCantidadEspecialidades() {
        return cantidadEspecialidades;
    }

    public void setCantidadEspecialidades(int cantidadEspecialidades) {
        this.cantidadEspecialidades = cantidadEspecialidades;
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
            
    
    public void determinarRutina(int pgc,String tipoE){
        if(pgc<=15 && "aerobico".equals(tipoE)){
            System.out.println("Realize Yoga");
        }
        if(pgc>15 && pgc<25 && "aerobico".equals(tipoE)){
            System.out.println("Realize trote de mediana de intensidad");
        }
        if(pgc>=25 && "aerobico".equals(tipoE)){
            System.out.println("Realize bailoterapia");
        }
        if(pgc<=15 && "anaerobico".equals(tipoE)){
            System.out.println("Realize Spinning");
        }
        if(pgc>15 && pgc<25 && "anaerobico".equals(tipoE)){
            System.out.println("Realize rutinas de pesas");
        }
        if(pgc>=25 && "anaerobico".equals(tipoE)){
            System.out.println("Realize trote alta de intensidad");
        }
    }
    public void determinarRutina(String frecuenciaE, int pgc){
        if(pgc<=15 && "diario".equals(frecuenciaE)){
            System.out.println("Realiza 50 saltos");
        }
        if(pgc>15 && pgc<25 && "diario".equals(frecuenciaE)){
            System.out.println("Realiza 15 mins de trote");
        }
        if(pgc>=25 && "diario".equals(frecuenciaE)){
            System.out.println("Realiza 200 abdominales");
        }
        if(pgc<=15 && "semanal".equals(frecuenciaE)){
            System.out.println("Realiza 50 saltos y trota 15 mins");
        }
        if(pgc>15 && pgc<25 && "semanal".equals(frecuenciaE)){
            System.out.println("Realiza 40 mins de trote");
        }
        if(pgc>=25 && "semanal".equals(frecuenciaE)){
            System.out.println("Realiza 400 abdominales");
        }
    }
    
}
    