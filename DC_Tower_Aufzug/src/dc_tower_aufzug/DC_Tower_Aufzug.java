/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc_tower_aufzug;

import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class DC_Tower_Aufzug {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Aufzufdatabase adb = new Aufzufdatabase(7);// Hier wird bestimmt wie viele Aufzüge es gibt
        int curentfloor = 0 ;
        int destinationfloor = 0;
        boolean keep = false;
        String choich ="";
        //Hier werden die Aufzüge erzeugt
        adb.addAufzug("Aufzug 1", 7);
        adb.addAufzug("Aufzug 2", 14);
        adb.addAufzug("Aufzug 3", 30);
        adb.addAufzug("Aufzug 4", 55);
        adb.addAufzug("Aufzug 5", 0);
        adb.addAufzug("Aufzug 6", 21);
        adb.addAufzug("Aufzug 7", 31);
        // Ausgabe der Aufzüge (Display wo sicher wer befindet)
        adb.printAufzug();
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        try{
            do{
                //Abfrage wo sie sich befinden
                System.out.println("Im welchen Stock befinden sie sich");
                curentfloor = s.nextInt();
                if(curentfloor < 0){
                    //Da es keinen Keller im Gebäude gibt bericht das Programm ab
                    System.out.println("Leider können die Aufzüge sich nicht in die Erde bohren");
                    keep=true;
                }else if(curentfloor > 55 ){
                    //Das Gebäude besitzt nur 55 Stockwerke
                    System.out.println("Sie können ja fliegen");
                    keep=true;
                }else{
                    //Abfrage wo Sie hinmöchten
                    System.out.println("Wo hin soll es gehen:");
                    destinationfloor = s.nextInt();
                    if(destinationfloor < 0){
                        System.out.println("Leider können die Aufzüge sich nicht in die Erde bohren");
                        keep=true;
                    }else if(destinationfloor > 55 ){
                        System.out.println("Unsere Aufzügekönnen leider nicht fliegen");
                        keep=true;
                    }else{
                        String c = adb.findNext(curentfloor);
                        int i = adb.setnewfloor(c, destinationfloor);
                        System.out.println("Näherste Aufzug ist:" + c);
                        System.out.println("Sie befinden sich nun im :" + i + " Stock");
                        System.out.print("Wollen sie weiter fahren? (Ja = j, Nein = n)");
                        choich = s2.nextLine();
                        if(choich.equals("n")){
                            keep = true; 
                        }
                    }
                }
                
            }while(!keep);
        }catch(Exception e){
            System.out.println("Da ist was schiefgelaufen");
        }
       
        
    }
    
}
