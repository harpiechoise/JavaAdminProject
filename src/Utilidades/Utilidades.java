/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author Harpie
 */
public class Utilidades {
    
    
    public Date escogerMembresia(int Tipo){
        Date tipoRetorno;
        switch(Tipo){
            case 1:
               tipoRetorno = Date.valueOf(LocalDate.now().plusDays(1));
               break;
            case 2:
               tipoRetorno = Date.valueOf(LocalDate.now().plusMonths(1));
               break;
            case 3:
                tipoRetorno = Date.valueOf(LocalDate.now().plusMonths(3));
                break;
            case 4:
                tipoRetorno = Date.valueOf(LocalDate.now().plusYears(1));
                break;
            default:
                tipoRetorno = null;
                break;
        }
        return tipoRetorno;
    }
    
    public Boolean esValidoRUT(String RUT){
        List Secuencia = Arrays.asList(2,3,4,5,6,7,2,3,4,5,6,7);
        String RUTListo = RUT.substring(0, RUT.length() - 1);
        ArrayList<Character> CharRUT;
        CharRUT = new ArrayList<Character>();
        for (char ch: RUTListo.toCharArray()){
            CharRUT.add(ch);
        }
        Collections.reverse(CharRUT);
        int res = 0;
        for (int i = 0; i < CharRUT.size(); i++){
           int n1 = Character.getNumericValue(CharRUT.get(i));
           int n2 = (int) Secuencia.get(i);
           res += n1 * n2;
        }
        int rutModulo = res % 11;
        int finalResult = 11 - rutModulo;
        String verDigi;

        
        switch (finalResult) {
            case 11:
                verDigi = "0";
                break;
            case 10:
                verDigi = "K";
                break;
            default:
                verDigi = Integer.toString(finalResult);
                break;
        }
        
        return Character.toString(RUT.charAt(RUT.length() - 1)).equals(verDigi);

                
    }
    
    public Boolean esValidoNumero(String Tarjeta){
        //TODO Validacion Luhn
        Tarjeta = new StringBuilder(Tarjeta).reverse().toString();
        int sum = 0;
        
        for (int i = 1; i < Tarjeta.length(); i += 2){
            int n = Character.getNumericValue(Tarjeta.charAt(i))*2;
            if (Integer.toString(n).length() == 2){
                sum += Character.getNumericValue(Integer.toString(n).charAt(0)) + Character.getNumericValue(Integer.toString(n).charAt(1));
            }else{
                sum += n;
            }   
            
        }
        for (int i = 0; i < Tarjeta.length(); i += 2){

            sum += Character.getNumericValue(Tarjeta.charAt(i));
          
        }
        
        return sum % 10 == 0;
           
    }
    
    public Boolean esValidoFecha(String AV, String Mes){
        //Todo Validar Fecha
        String TwoNumbs = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        int TwoNumbsInt = Integer.parseInt(TwoNumbs.substring(TwoNumbs.length() - 2));
        if (Mes.contains("0")){
            Mes = Mes.substring(1);
        }
        return Integer.parseInt(AV) > TwoNumbsInt || Integer.parseInt(Mes) > Calendar.getInstance().get(Calendar.MONTH) && Integer.parseInt(AV) == TwoNumbsInt ;
     
                
    }
    
    public Boolean esValidoCVV2(String CVV2, String Tarjeta){
        //Todo Verificar Longitud
        if('4' == Tarjeta.charAt(0) || '5' == Tarjeta.charAt(0)){
            return CVV2.length() == 3;
        }else{
            return CVV2.length() == 4;
        }
    }
    
    public Boolean esValidoCorreo(String Correo){
        return Correo.contains("@");
    }
    
    public Boolean esValidoTelefono(String Telefono){
        return Telefono.contains("+") && Telefono.length() == 12 || Telefono.length() == 8;
    }
    
    public ImageIcon cargarYRedimensionar(String FileName, Point nuevoTamano) throws IOException{
        
        try{
            Image img = ImageIO.read(new File(FileName));
            ImageIcon resizedImage = new ImageIcon(img.getScaledInstance(nuevoTamano.x, nuevoTamano.y, Image.SCALE_DEFAULT));
            return resizedImage;
        
        }catch(IOException e){
            System.out.println("El Elemento No Existe");
            return null;
        }   
    }
    public ImageIcon tarjetaLinkMaker(String Numero){
        char primerNumero = Numero.charAt(0);
        String path;
        ClassLoader classLoader = getClass().getClassLoader();
        Point dimensiones;
        switch(primerNumero){
            case '4':
                path = classLoader.getResource("CardIcon/visa.png").getPath();
                dimensiones = new Point(32,20);
                break;
            case '5':
                path = classLoader.getResource("CardIcon/mastercard.png").getPath();
                dimensiones = new Point(32,20);
                break;
            case '3':
                path = classLoader.getResource("CardIcon/amex.png").getPath();
                dimensiones = new Point(32,20);
                break;
            default:
                path = classLoader.getResource("CardIcon/card.png").getPath();
                dimensiones = new Point(32,20);
                break;
        }
        
        
        try{
            return cargarYRedimensionar(path, dimensiones);
        }catch(IOException e){
            System.out.println("Se produjo un error al cargar la imagen");
            return null;
        }
        
    
        
        
    }
    public ImageIcon returnDefault() throws IOException{
        Point dimensiones = new Point(32,20);
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("CardIcon/card.png").getPath();
        return cargarYRedimensionar(path, dimensiones);
    }

    public ImageIcon returnCheck(Boolean CheckType) throws IOException{
        Point dimensiones = new Point(16,16);
        String path;
        ClassLoader classLoader = getClass().getClassLoader();
        if (CheckType){
            path = classLoader.getResource("checkIcon/good.png").getPath();
            return cargarYRedimensionar(path, dimensiones);
        }else{
            path = classLoader.getResource("checkIcon/bad.png").getPath();
            return cargarYRedimensionar(path, dimensiones);
        }
    }
}



