/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Wnieto
 */

import java.util.ArrayList;
import model.Equipo;
import model.Municipio;


public class TorneoController {
    public boolean insertMunicipio(String nombre){
        Municipio municipio = new Municipio();
        municipio.nombre = nombre;
        return municipio.insert();
    }
    
    public boolean updateMunicipio(int id, String nombre){
        Municipio municipio = new Municipio();
        municipio.id = id;
        municipio.nombre = nombre;
        return municipio.update();
    }
    
    public boolean deleteMunicipio(int id){
        Municipio municipio = new Municipio();
        return municipio.delete(id);
    }      
    
    public Municipio findMunicipio(int id){
        Municipio municipio = new Municipio();
        return municipio.find(id);
    } 

    
    public ArrayList<Municipio> SelectMunicipios(){
        Municipio municipio = new Municipio();
        return municipio.select();
    }
    
    /*  ---Equipo---   */
    public boolean insertEquipo(String nombre, String dt, int id_municipio){
        Equipo equipo = new Equipo();
        equipo.nombre = nombre;
        equipo.dt = dt;
        equipo.id_municipio = id_municipio;
        return equipo.insert();
    }
    
  /*  public boolean updateEquipo(int id, String nombre){
        Equipo equipo = new Equipo();
        equipo.id = id;
        equipo.nombre = nombre;
        return equipo.update();
    }
 */   
    public boolean deleteEquipo(int id){
        Equipo equipo = new Equipo();
        return equipo.delete(id);
    }      
    
    public ArrayList<Equipo> SelectEquipos(){
        Equipo equipo = new Equipo();
        return equipo.select();
    }
    
    public Equipo findEquipo(int id){
        Equipo equipo = new Equipo();
        return equipo.find(id);
    } 
    
    public boolean updateEquipo(int id, String nombre, String dt, int id_municipio){
        Equipo equipo = new Equipo();
        equipo.id = id;
        equipo.nombre = nombre;
        equipo.dt = dt;
        equipo.id_municipio = id_municipio;
        return equipo.update();
    }    
}
