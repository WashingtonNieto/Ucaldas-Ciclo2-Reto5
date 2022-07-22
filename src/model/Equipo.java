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
public class Equipo extends DbData{
    public int id;
    public String nombre;
    public String dt;
    public int id_municipio;

    @Override
    public String toString() {
        return "" + id + " - " + nombre + " - " + dt + " - " +id_municipio;
    }
    
    public boolean insert(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO equipo VALUES (null,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,dt);
            sentencia.setInt(3,id_municipio);
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
    
    
    public boolean update(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE equipo SET nombre=?, dt=?, id_municipio=? WHERE id_equipo=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,dt);
            sentencia.setInt(3,id_municipio);
            sentencia.setInt(4,id);
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
    public ArrayList<Equipo> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM equipo";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Equipo> listaEquipos = new ArrayList<>();
            while(rs.next()){
                Equipo equipo = new Equipo();
                equipo.id = rs.getInt(1);
                equipo.nombre = rs.getString(2);
                equipo.dt = rs.getString(3);
                equipo.id_municipio = rs.getInt(4);
                listaEquipos.add(equipo);
            }
            connection.close();
            return listaEquipos;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public Equipo find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM  equipo WHERE id_equipo=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Equipo equipo = new Equipo();
            if(rs.next()){
                equipo.id = rs.getInt(1);
                equipo.nombre = rs.getString(2);
                equipo.dt = rs.getString(3);
                equipo.id_municipio = rs.getInt(4);
            }else{
                equipo = null;
            }
            connection.close();
            return equipo;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public boolean delete(int id) {
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM equipo WHERE id_equipo=?";
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
