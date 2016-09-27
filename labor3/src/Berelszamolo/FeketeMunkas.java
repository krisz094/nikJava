/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Berelszamolo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author krisz
 */
public class FeketeMunkas implements IKirughato{
    public String név;
    public LinkedList<Integer> fizetések;
    public FeketeMunkas(String név) {
        this.név=név;
        fizetések = new LinkedList<Integer>();
    }
    public void hozzáadFizetést(int mennyit){
        fizetések.add(mennyit);
    }

    @Override
    public int vegKielegites() {
        int tempSum = 0;
        if (fizetések.size() > 0) {
            for (int i = 0; i < fizetések.size(); i++) {
                tempSum += fizetések.get(i);
            }
            tempSum /= fizetések.size();
        }
        return (int)(java.lang.Math.PI * java.lang.Math.sqrt(tempSum));
    }
}
