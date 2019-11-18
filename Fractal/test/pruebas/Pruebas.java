package pruebas;

import dao.Conexion;
import java.sql.Connection;

public class Pruebas {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection cnx = conexion.conectar();
        if(cnx==null){
            System.out.println("Error en la Base de datos");
            System.out.println(cnx);
        }else{
            System.out.println("Cañón");
        }
    }
}
