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
//Erzeugen der Aufzüge dabei werden nur Namen und das aktuelle Stockwerk der Klasse Auzug mitgeben 
public class Aufzufdatabase {
    private Aufzug[] aufzug;
    
    public Aufzufdatabase(int size){
        aufzug = new Aufzug[size];
    }
    //Logik um Aufzüge zu finden 
    //Sollte keine da sein wird ausgeben das die datenbank voll ist
    public void addAufzug(String name, int floor){
        int findex = -1;
        
        for(int i = 0; i< aufzug.length; i++){
            if(aufzug[i]==null){
                findex = i;
                break;
            }
        }
        
        if(findex==-1){
            System.out.println("Datenbank ist voll");
        }else{
            aufzug[findex] = new Aufzug( name,  floor);
        }
    }
    // Logik um den nähersten aufzug zu finden
    public String findNext(int findfloor){
        int i =0; 
        
        int j = Math.abs(aufzug[0].floor - findfloor);
        for(int x = 0; x < aufzug.length; x++){
            int cj = Math.abs(aufzug[x].floor - findfloor);
            if(cj < j){
                i = x;
                j = cj;
            }
        }
        return aufzug[i].name;
    }
    //Der gefundene Aufzug bekommt hier das geünschte Sockwerk mit (Also er fährt dort hin )
    public int setnewfloor(String Aufzugname , int myfloor){
        int temp = 0 ;
        String temp2 = Aufzugname;
        for(int i = 0; i < aufzug.length; i++){
            if(temp2 == aufzug[i].name){
                temp = i;
                aufzug[i].floor = myfloor;
            }
        }
        
        return aufzug[temp].floor; 
    }
    //Ausgabe der Aufzüge
    public void printAufzug(){
        for(Aufzug a : aufzug){
            a.printAufzug();
        }
    }
  
}
