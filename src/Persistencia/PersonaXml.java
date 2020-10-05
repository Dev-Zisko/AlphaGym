/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Persona;
import Dominio.Entrenador;
import Dominio.Deportista;
import Dominio.Ejercicio;
import Dominio.Gimnasio;
import Dominio.Especialidad;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class PersonaXml {
   
    private Element root;
   
    private String fileLocation = "src//Archivos//BaseDatos.xml";
    /**
     * constructor por defecto que inicia los valores para trabajar con el documento
     * xml
     */
    public PersonaXml() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }

    private Element PersonatoXmlElement(Persona nPersona) {
        Element personaE = new Element("Persona");
        
        if (nPersona instanceof Entrenador){
           Element tipo= new Element("Tipo");
           Entrenador en = (Entrenador) nPersona;
           tipo.setText(en.getTipo());
           Element experiencialaboral = new Element("AñosExperiencia");
           experiencialaboral.setText(Integer.toString(en.getExperienciaLaboral()));
           Element especialidadT = new Element("Especialidades");
           if(en.getEspecialidades()!=null){
            for(Especialidad esp : en.getEspecialidades()){
               
               Element especialidad = new Element("Especialidad");
               Element nombre = new Element("NombreEspecialidad");
               Element horas = new Element("HorasDictadas");
               nombre.setText(esp.getNombreesp());
               horas.setText(Integer.toString(esp.getHoras()));
               especialidad.addContent(nombre);
               especialidad.addContent(horas);
               especialidadT.addContent(especialidad);
            } 
           }
           
           personaE.addContent(experiencialaboral);
           personaE.addContent(tipo);
           personaE.addContent(especialidadT);
        }
        if (nPersona instanceof Deportista){
           Element tipo= new Element("Tipo");
           Deportista de = (Deportista) nPersona;
           tipo.setText(de.getTipo());
           Element ritmoc = new Element("RitmoCardiaco");
           Element frecuenciae = new Element("FrecuenciaEntrenamiento");
           Element tipoe = new Element("TipoEjercicio");
           Element cantidade = new Element("CantidadEjercicio");
           ritmoc.setText(Integer.toString(de.ritmoc));
           frecuenciae.setText(de.frecuenciaE);       
           tipoe.setText(de.tipoE);
           cantidade.setText(Integer.toString(de.getCantidadEjercicios()));
           Element ejercicios = new Element("Ejercicios");
           if(de.getEjercicios()!=null){
            for(Ejercicio eje : de.getEjercicios()){
               Element ejercicio = new Element("Ejercicio");
               Element nombre = new Element("NombreEjercicio");
               Element objetivo = new Element("Objetivo");
               nombre.setText(eje.getNombreej());
               objetivo.setText(eje.getObjetivo());
               ejercicio.addContent(nombre);
               ejercicio.addContent(objetivo);
               ejercicios.addContent(ejercicio);
            }
           }
           personaE.addContent(ritmoc);
           personaE.addContent(frecuenciae);
           personaE.addContent(tipoe);
           personaE.addContent(cantidade);
           personaE.addContent(tipo);
           personaE.addContent(ejercicios);
        }   
        
        Element cedula = new Element("Cedula");
        cedula.setText(Integer.toString(nPersona.getCedula()));
        
        Element nombre = new Element("Nombre");
        nombre.setText(nPersona.getNombre());
        
        Element edad = new Element("Edad");
        edad.setText(Integer.toString(nPersona.getEdad()));
        
        Element sexo = new Element("Sexo");
        sexo.setText(nPersona.getSexo());
        
        Element peso = new Element("Peso");
        peso.setText(Double.toString(nPersona.getPeso()));

        Element altura = new Element("Altura");
        altura.setText(Double.toString(nPersona.getAltura()));
        
        Element direccion = new Element("Direccion");
        direccion.setText(nPersona.getDireccion());

        personaE.addContent(cedula);
        personaE.addContent(nombre);
        personaE.addContent(edad);
        personaE.addContent(sexo);
        personaE.addContent(peso);
        personaE.addContent(altura);
        personaE.addContent(direccion);
        return personaE;
    }
    
     private Persona PersonaToObject(Element element) throws ParseException {
       Persona nPersona = new Persona(Integer.parseInt(element.getChildText("Cedula")), element.getChildText("Nombre"), Integer.parseInt(element.getChildText("Edad")), element.getChildText("Sexo") ,Double.parseDouble(element.getChildText("Peso")),Double.parseDouble(element.getChildText("Altura")), null) {
           @Override
           public int calcularIMC(double peso, double altura, int edad, char sexo) {
               return(0);
           }
         
       };
       return nPersona;
    }
     private Entrenador EntrenadorToObject (Element element) throws ParseException {
       Entrenador nPersona = new Entrenador(element.getChildText("Tipo"), Integer.parseInt(element.getChildText("AñosExperiencia")), Integer.parseInt(element.getChildText("Cedula")), element.getChildText("Nombre"), Integer.parseInt(element.getChildText("Edad")), element.getChildText("Sexo") ,Double.parseDouble(element.getChildText("Peso")),Double.parseDouble(element.getChildText("Altura")), null);
       return nPersona;
     }
    
     private Deportista DeportistaToObject (Element element) throws ParseException {
       Deportista nPersona = new Deportista(element.getChildText("Tipo"), Integer.parseInt(element.getChildText("RitmoCardiaco")), element.getChildText("FrecuenciaEntrenamiento"), element.getChildText("TipoEjercicio"), Integer.parseInt(element.getChildText("CantidadEjercicio")), Integer.parseInt(element.getChildText("Cedula")), element.getChildText("Nombre"), Integer.parseInt(element.getChildText("Edad")), element.getChildText("Sexo") ,Double.parseDouble(element.getChildText("Peso")),Double.parseDouble(element.getChildText("Altura")), null);
       return nPersona;
     }
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean agregarPersona(Persona nPersona) {
        boolean resultado = false;
        root.addContent(PersonatoXmlElement((Persona) nPersona));
        resultado = updateDocument();
        return resultado;
    }
    
    public ArrayList<Persona> todasLasPersonas() {
        ArrayList<Persona> resultado = new ArrayList<Persona>();     
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {               
                if(new String("Entrenador").equals(xmlElem.getChildText("Tipo"))){
                resultado.add(EntrenadorToObject(xmlElem));               
                }
                if(new String("Deportista").equals(xmlElem.getChildText("Tipo"))){
                resultado.add(DeportistaToObject(xmlElem));
                }                    
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
    
    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Cedula").getText())) {
                return e;
            }
        }
        return null;
    }
    
    public Persona buscarPersona(Integer cedula) {
        Element aux = new Element("Persona");
        List Personas = this.root.getChildren("Persona");
        while (aux != null) {
            
            aux = PersonaXml.buscar(Personas, Integer.toString(cedula));
            if (aux != null) {
                try {
                    return PersonaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public boolean actualizarPersona(Persona nPersona) {
        boolean resultado = false;
        Element aux = new Element("Persona");
        List Personas = this.root.getChildren("Persona");
        while (aux != null) {
            aux = PersonaXml.buscar(Personas, Integer.toString(nPersona.getCedula()));
            if (aux != null) {
                Personas.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarPersona(nPersona);
        return resultado;
    }

    public boolean borrarPersona(Integer cedula) {
        boolean resultado = false;
        Element aux = new Element("Persona");
        
        List Personas = this.root.getChildren("Persona");
        
        while (aux != null) {
            aux = PersonaXml.buscar(Personas, Integer.toString(cedula));
            
            if (aux != null) {
                Personas.remove(aux);
                resultado = updateDocument();
                
            }
        }
        return resultado;
    }


    
}
