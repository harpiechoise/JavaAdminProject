/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Harpie
 */
public class Genero {
    public Genero(){

    }
    public int hacerConsulta(String Nombre) throws Exception{
        if (Nombre.split("\\s+").length > 1){
            Nombre = Nombre.split("\\s+")[0];
        }
        
        StringBuilder resultadoRespuesta = new StringBuilder();
        String urlFormated = String.format("https://api.genderize.io/?name=%s", Nombre);
        URL urlPeticion = new URL(urlFormated);
        HttpURLConnection conn = (HttpURLConnection) urlPeticion.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader readerResponse = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = readerResponse.readLine()) != null){
            resultadoRespuesta.append(line);
        }
        readerResponse.close();
        
        JSONParser responseParser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) responseParser.parse(resultadoRespuesta.toString());
        String gender = jsonResponse.get("gender").toString();
        if (gender.equals("male")){
            return 0;
        }
        if (gender.equals("female")){
            return 1;
        }
        else {
            return 404;
        }
    }
    
    
}
