/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import principal.FrmMenuSuccessful;

/**
 *
 * @author Piero
 */
public class CLogin {
    
    String username;
    
    
    public void validarUsuario(String usuario, String password){
        try{
            ResultSet rs=null;
            PreparedStatement ps=null;
            
            
            Clases.CConexion objetoConexion= new Clases.CConexion();
            
            String consulta = "select * from users where usuario=(?) and password =(?)";
            
            
            ps= objetoConexion.establecerConexion().prepareStatement(consulta);
              
            ps.setString(1,usuario);
            ps.setString(2,password);

              
            rs= ps.executeQuery();
            
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Usuario correcto");
                FrmMenuSuccessful objetoMenu= new FrmMenuSuccessful();
                objetoMenu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Credneciales incorrectas");
            }
            
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"probelmas en la conexion"+e);
        }
    }
    
}
