/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labor4szerver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author krisz094
 */
public class Labor4Szerver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String,String> szotar = new HashMap<>();
        szotar.put("what", "mi");
        szotar.put("dog", "kutya");
        szotar.put("cat", "macska");
        szotar.put("pokemon", "zsebszörny");
        szotar.put("gypsy", "Győzike");
        try {
            ServerSocket ss = new ServerSocket(3001);
            while(true) {
                Socket s = ss.accept(); //socket nyitás
                
                InputStream is = s.getInputStream(); //inputStream cuccok
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                
                OutputStream os = s.getOutputStream(); //outputStream cuccok
                PrintWriter bos = new PrintWriter(os);
                
                String query = br.readLine();
                switch(query.charAt(0)) {
                    case 'p': //print
                                kiirMindet(bos, szotar);
                                break;
                    case 'n': //new
                                ujFelvetele(bos, szotar, query.substring(1));
                                break;
                    case 't': //translate
                                lefordit(bos, szotar, query.substring(1));
                                break;
                }
                
            }
            
        }
        catch( IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void kiirMindet(PrintWriter bos,Map<String,String> szotar) {
        
        szotar.entrySet().stream().map((bejegyzes) -> {
            bos.println(bejegyzes.getKey() + ": " + bejegyzes.getValue());
            return bejegyzes;
        }).forEach((_item) -> {
            bos.flush();
        });
        /*
        for(Map.Entry<String,String> bejegyzes: szotar.entrySet()) {
            bos.println(bejegyzes.getKey() + ": " + bejegyzes.getValue());
            bos.flush();
        }
        */
        bos.close();
    }
    public static void ujFelvetele(PrintWriter bos, Map<String,String> szotar, String szo) {
        String[] splittelt = szo.split("\\$");   
        szotar.put(splittelt[0], splittelt[1]);
        bos.println("new word added: " + splittelt[0] + ": " + splittelt[1]);
        bos.flush();
        bos.close();
    }
    public static void lefordit(PrintWriter bos, Map<String,String> szotar, String szo) {
        String leforditott = szotar.get(szo);
        if (leforditott != null) {
            bos.println(szo + ": " + leforditott);
            bos.flush();
        }
        else {
            bos.println(szo + " nem szerepel az adatbázisban");
            bos.flush();
        }
        bos.close();
    }
}
