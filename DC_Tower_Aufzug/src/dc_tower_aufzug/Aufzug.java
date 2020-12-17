/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc_tower_aufzug;

/**
 *
 * @author Andreas
 */
// Einfaches Klassen Modell für den Aufzug
public class Aufzug {
    String name;
    int floor =0; 
    int nowfloor=0;

    public Aufzug(){

    }
    public Aufzug(String name, int floor){
        this.name = name;
        this.floor = floor;
        
    }
    // Ausgabe der Aufzüge die Exsistieren.
    public void printAufzug(){
        System.out.println(name +" " + floor);
    }

}