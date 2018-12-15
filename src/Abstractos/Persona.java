/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstractos;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Harpie
 */
public class Persona {
    
    String Nombre;
    String Rut;
    String Telefono;
    String Mail;
    Boolean esSocio;
    Date caducidadMembresia;
    int Genero;
    
    public Persona(String Nombre, int Genero, String Rut, String Telefono, String Mail, Boolean esSocio){
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.Telefono = Telefono;
        this.Mail = Mail;
        this.esSocio = esSocio;
        this.Genero = Genero;
    }
    public void añadirMembresia(Date Caducidad){
        if (Caducidad == null && !esSocio){
            this.caducidadMembresia = Date.valueOf(LocalDate.now());
        }
        else{
            this.caducidadMembresia = Caducidad;
        }
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getRut(){
        return this.Rut;
    }
    public String getTelefono(){
        return this.Telefono;
    }
    public String getMail(){
        return this.Mail;
    }
    public int getGenero(){
        return this.Genero;
    }
    public String getGeneroString(){
        if(this.Genero == 0){
            return "Hombre";
        }
        else{
            return "Mujer";
        }
    }
    public Boolean getSocio(){
        return this.esSocio;
    }
    
}
