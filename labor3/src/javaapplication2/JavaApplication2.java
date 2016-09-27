/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import Berelszamolo.Dolgozo;
import Berelszamolo.GyerekesDolgozo;
import java.util.Scanner;

/**
 *
 * @author hallgato
 */
public class JavaApplication2 {

      
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        java.util.Vector<Dolgozo> dolgozoVector = new java.util.Vector<>();
        
        char lenyomott = 'a';
        
        while (lenyomott != 'q')         
        {
            System.out.println("1. új csávó felvétele\n2. átlagnál nagyobb kifizetendő\n3. megadott helyen dolgozók törlése");
            
            lenyomott = reader.next().charAt(0);
            if (lenyomott == '1') {
                
                System.out.println("név: ");
                String név = reader.next();
                System.out.println("előző munkahelyek: ");
                String[] elozok = reader.next().split(",");
                System.out.println("fizetés: ");
                int fizetés = reader.nextInt();
                System.out.println("gyerekes?");
                boolean gyerekes = reader.next().equals("igen");
                
                if (!gyerekes) {
                   dolgozoVector.add(new Dolgozo(név,elozok,fizetés)); 
                } else {
                    System.out.println("családi pótlék: ");
                    int családiPótlék = reader.nextInt();
                    dolgozoVector.add(new GyerekesDolgozo(név, elozok, fizetés, családiPótlék));
                }
                
            } else if (lenyomott == '2') {
                //TODO átlagnál nagyobb kifizetendő
            } else if (lenyomott == '3') {
                System.out.println("melyikeket töröljük?");
                String melyiket = reader.next();
                for (int i = 0; i < dolgozoVector.size(); i++)
                {
                    for (int j = 0; j < dolgozoVector.get(i).előzőMunkahelyei.length; j++)
                    {
                        if (dolgozoVector.get(i).előzőMunkahelyei[j].equals("asd"))
                        {
                            dolgozoVector.remove(i);
                        }
                    }
                }
            }
        }
        

    }
    
}
