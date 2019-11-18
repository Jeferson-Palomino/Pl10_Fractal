package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
   public Connection cnx = null;
   
   public Connection conectar(){
       try {
           String driver = "com.mysql.jdbc.Driver";
           String url = "jdbc:mysql://localhost:3306/fractal";
           String user = "root";
           String pwd = "";
           Class.forName(driver).newInstance();
           cnx = DriverManager.getConnection(url, user, pwd);
       } catch (Exception e) {
           System.out.println("Error en la conexión " + e.getMessage());
       }
       return cnx;
   }
   
   public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection cnx = conexion.conectar();
        if(cnx==null){
            System.out.println("No hay conexión");
            System.out.println(cnx);
        }else{
            System.out.println("Conectado");
        }
    }
   
   public void desconectar() throws SQLException{
       if(cnx==null){
           return;
       }else{
           cnx.close();
       }           
   }   

}
