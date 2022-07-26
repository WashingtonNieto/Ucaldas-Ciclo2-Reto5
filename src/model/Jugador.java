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
public class Jugador extends DbData{

    public int id;
    public String nombre;
    public String numero;
    public int id_equipo;
    public int id_posicion;

    @Override
    public String toString() {
        return "" + id + " - " + nombre + " - " + id_equipo;
    }
    
    public boolean insert(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO jugador VALUES (null,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,numero);
            sentencia.setInt(3,id_equipo);
            sentencia.setInt(4,id_posicion);
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
            String query = "UPDATE jugador SET nombre=?, numero=?, id_equipo=?, id_posicion=? WHERE id_equipo=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,numero);
            sentencia.setInt(3,id_equipo);
            sentencia.setInt(4,id_posicion);
            sentencia.setInt(5,id);
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
    public ArrayList<Jugador> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM jugador";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Jugador> listaJugadores = new ArrayList<>();
            while(rs.next()){
                Jugador jugador = new Jugador();
                jugador.id = rs.getInt(1);
                jugador.nombre = rs.getString(2);
                jugador.numero = rs.getString(3);
                jugador.id_equipo = rs.getInt(4);
                jugador.id_posicion = rs.getInt(4);
                listaJugadores.add(jugador);
            }
            connection.close();
            return listaJugadores;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public Jugador find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM  jugador WHERE id_jugador=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Jugador jugador = new Jugador();
            if(rs.next()){
                jugador.id = rs.getInt(1);
                jugador.nombre = rs.getString(2);
                jugador.numero = rs.getString(3);
                jugador.id_equipo = rs.getInt(4);
                jugador.id_posicion = rs.getInt(5);
            }else{
                jugador = null;
            }
            connection.close();
            return jugador;
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
            String query = "DELETE FROM jugador WHERE id_jugador=?";
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
