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
public class GyerekesDolgozo extends Dolgozo{
    public int családiPótlék;
    
    public GyerekesDolgozo (String név, String[] előzőMunkahelyei, int fizetés, int családiPótlék) {
        super(név,előzőMunkahelyei,fizetés);
        this.családiPótlék = családiPótlék;
    }
    
    public int getFizetendo() {
        return fizetés / 2 + családiPótlék;
    }
}
