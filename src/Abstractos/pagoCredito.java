/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstractos;

import javax.swing.JOptionPane;

/**
 *
 * @author Harpie
 */
public class pagoCredito {
    String NumeroTarjeta;
    String CCV2;
    String Fecha;
    
    Boolean isValidNumero = false;
    Boolean isValidCCV2 = false;
    Boolean isValidFecha = false;
    
    
    public pagoCredito(String Numero, String CCV2, String Fecha){
        this.NumeroTarjeta = Numero;
        this.CCV2 = CCV2;
        this.Fecha = Fecha;
    }
    
    public String getNumero(){
        if (this.isValidNumero == true && this.isValidCCV2 == true && this.isValidFecha == true){ 
            return this.NumeroTarjeta;
        }else{
            return null;
        }
        
    }
    
    public String getCCV2(){
        if (this.isValidNumero == true && this.isValidCCV2 == true && this.isValidFecha == true){ 
            return this.CCV2;
        }else{
            return null;
        }
        
    }
    
    public String getFecha(){
        if (this.isValidNumero == true && this.isValidCCV2 == true && this.isValidFecha == true){ 
            return this.Fecha;
        }else{
            return null;
        }
        
    }

}
