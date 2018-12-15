
package API;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBUtils {
    
    public Connection conectar(String DataBase, String Usuario, String Contraseña){
        try{
            Connection conn;
            String url = String.format("jdbc:mysql://127.0.0.1/%s", DataBase);
            conn = DriverManager.getConnection(url, Usuario, Contraseña);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos");
        }
        return null;
    }
    
    
    
}
