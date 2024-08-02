/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Piero
 */
public class CConexion {
    
    Connection conectar;
    
    String usuario="root";
    String contrasenia="piero2000";
    String bd = "studentdb";
    String ip="localhost";
    String puerto="3306";
    
    String cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            
            //JOptionPane.showMessageDialog(null,"Se conecto a la bd");

            
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"probelmas en la conexion"+e);
        }
        
        return conectar;
    }
}
