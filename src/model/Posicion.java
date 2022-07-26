/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Wnieto
 */
public class Posicion extends DbData{
    public int id;
    public String nombre;

    @Override
    public String toString() {
        return id + " - " + nombre ;
    }
    
    public boolean insert(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO posicion VALUES (null,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0){
                return true;
            }else{
                return false;
            }
        } catch(Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }
    
    public ArrayList<Posicion> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM posicion";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Posicion> listaPosiciones = new ArrayList<>();
            while(rs.next()){
                Posicion posicion = new Posicion();
                posicion.id = rs.getInt(1);
                posicion.nombre = rs.getString(2);
                listaPosiciones.add(posicion);
            }
            connection.close();
            return listaPosiciones;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public Posicion find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM  posicion WHERE id_posicion=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Posicion posicion = new Posicion();
            if(rs.next()){
                posicion.id = rs.getInt(1);
                posicion.nombre = rs.getString(2);
            }else{
                posicion = null;
            }
            connection.close();
            return posicion;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }

    public boolean update() {
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE posicion SET nombre = ? WHERE id_posicion=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0 ){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }
    
    public boolean delete(int id) {
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM posicion WHERE id_posicion=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0 ){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }    
}
