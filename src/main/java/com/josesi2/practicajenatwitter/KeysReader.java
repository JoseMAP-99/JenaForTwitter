package com.josesi2.practicajenatwitter;

import java.io.*;

/**
 *
 * @author José María
 */
public class KeysReader {
    
    private File file;
    protected String [] keys;
    
    public KeysReader(String path) {
        this.file = new File(path);
        this.keys = new String[4];
    }
    
    public boolean init() {  
        BufferedReader br;
        int i = 0;
        
        try {
            br = new BufferedReader(new FileReader(file));            
            String st;
            while ((st = br.readLine()) != null) {
              if (i > 3) {
                  System.out.println("El formato del fichero es erróneo");
              }
              if (st.contains(" ")) continue;
              keys[i] = st;
              i++;
            }
        
        } catch (FileNotFoundException ex) {
            System.out.println("Resource not found");
            return false;
        } catch (IOException ex) {
            System.out.println("Resource disconnected");
            return false;
        }
        return true;
    }
    
    public String[] getKeys() {
        return this.keys;
    }
}
