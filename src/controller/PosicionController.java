/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Posicion;
/**
 *
 * @author Wnieto
 */
public class PosicionController {
    public boolean insertPosicion(String nombre){
        Posicion posicion = new Posicion();
        posicion.nombre = nombre;
        return posicion.insert();
    }
    
    public boolean updatePosicion(int id, String nombre){
        Posicion posicion = new Posicion();
        posicion.id = id;
        posicion.nombre = nombre;
        return posicion.update();
    }
    
    public boolean deletePosicion(int id){
        Posicion posicion = new Posicion();
        return posicion.delete(id);
    }      
    
    public Posicion findPosicion(int id){
        Posicion posicion = new Posicion();
        return posicion.find(id);
    } 

    
    public ArrayList<Posicion> SelectPosicion(){
        Posicion posicion = new Posicion();
        return posicion.select();
    }    
}
