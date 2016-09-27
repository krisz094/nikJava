/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Berelszamolo;

/**
 *
 * @author hallgato
 */
public class Dolgozo implements IKirughato {
    // var
    public String név;
    public String[] előzőMunkahelyei;
    public int fizetés;
     
    public Dolgozo(String név, String[] előzőMunkahelyei, int fizetés) {
        this.név = név;
        this.előzőMunkahelyei = előzőMunkahelyei;
        this.fizetés = fizetés;
    }
    //method
    public int getKifizetendo() {
        return fizetés/2;
    } 

    @Override
    public int vegKielegites() {
        return fizetés*3;
    }
}

