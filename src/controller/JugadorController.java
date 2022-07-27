/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Jugador;

/**
 *
 * @author Wnieto
 */
public class JugadorController {
    public boolean insertJugador(String nombre, String numero, int id_equipo, int id_posicion){
        Jugador jugador = new Jugador();
        jugador.nombre = nombre;
        jugador.numero = numero;
        jugador.id_equipo = id_equipo;
        jugador.id_posicion = id_posicion;
        return jugador.insert();
    }
    
    public boolean updateJugador(int id, String nombre, String numero, int id_equipo, int id_posicion){
        Jugador jugador = new Jugador();
        jugador.id = id;
        jugador.nombre = nombre;
        jugador.numero = numero;
        jugador.id_equipo = id_equipo;
        jugador.id_posicion = id_posicion;
        return jugador.update();
    }
    
    public boolean deleteJugador(int id){
        Jugador jugador = new Jugador();
        return jugador.delete(id);
    }      
    
    public ArrayList<Jugador> SelectJugador(){
        Jugador jugador = new Jugador();
        return jugador.select();
    }
    
    public Jugador findJugador(int id){
        Jugador jugador = new Jugador();
        return jugador.find(id);
    } 
    
  
}
