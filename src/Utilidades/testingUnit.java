/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import API.Genero;
import java.util.Calendar;

/**
 *
 * @author Harpie
 */
public class testingUnit {
    public static void main(String args[]) throws Exception{
        Genero genNombre = new Genero();
        String Nombre = "Maria Del Carmen";
        System.out.println(Nombre.split("\\s+")[0]);
    }
}
