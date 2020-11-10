package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    //variables para acceder a la base de datos
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_calificaciones";
    static String usuario = "root";
    static String password = "";
    //variable para conectar y ejecutar una query en la bd
    protected Connection conn = null;

    //constructor
    public ConexionBD() {
        try {
            //especificacion del driver
            Class.forName(driver);
            //crear la conexion a la base de datos
            conn = DriverManager.getConnection(url, usuario, password);

            //verificar si la conexion es valida
            if (conn != null) {
                System.out.println("Conexion Exitosa " + conn);
            }

        } catch (ClassNotFoundException ex) {
            //ClassNotFoundException si  es que hay un error
            System.out.println("Error en Driver" + ex.getMessage());
        } catch (SQLException ex) {
            //SQLException si es que hay error en la consulta
            System.out.println("Error al conectar :" + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Cerrando la BD : "+conn);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error de SQL "+e.getMessage());
        }
    }
    
    
}
