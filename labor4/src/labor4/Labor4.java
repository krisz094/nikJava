/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labor4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisz094
 */
public class Labor4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String readChar = " ";
            String toSend = "";
            while (readChar.charAt(0) != 'q') {
                System.out.println("1: add new words\n2: translate word\n3: print all known words\nq: exit");
                readChar = br.readLine();
                if (readChar.charAt(0) != 'q') {
                    switch(readChar.charAt(0)) {
                    case '1': 
                        toSend = "n";
                        System.out.println("English word: ");
                        toSend += br.readLine();
                        System.out.println("Hungarian word: ");
                        toSend += "$" + br.readLine();
                        break;
                    case '2':
                        System.out.println("Which word? ");
                        toSend = "t" + br.readLine();
                        break;
                    case '3':
                        toSend = "p";
                        break;      
                    }
                    openSocketAndGetAnswer(toSend);
                }
                
                
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void openSocketAndGetAnswer(String message) {
        try {
            Socket soc = new Socket("127.0.0.1",3001);
            OutputStream os = soc.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            
            InputStream is = soc.getInputStream();
            
            pw.println(message);
            pw.flush();

            int a;
            while ( (a = is.read()) != -1) {
                System.out.print((char)a);
            }           
           
            pw.close();
            os.close();
            is.close();
            
            
                          
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
