package io;

import java.io.*;
import java.util.*;

public class IO {
    private Scanner read = new Scanner(System.in);
    BufferedWriter bufferWriter = null;
    
    public Boolean checkDir(){
        try {
            String dirName ="C:/JavaIO/Error/";
            File directory = new File(dirName);
            
            if (!directory.exists()){
                System.out.println("creating directory " + dirName);
                Boolean exists = false;
                try{
                    exists = directory.mkdirs();
                    System.out.println("created");
                } catch(SecurityException error) {
                    // handle error
                }
            }
            return true;
        } catch(SecurityException eror){
            // handle error
        } catch (Exception error) {
            // handle error
        }
        return false;
    }
    
    public void appendToFile(){
        if (checkDir()){
            try{
                File file = new File("C:/JavaIO/Error/Error.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                System.out.println("Enter text to append: ");
                String message = read.nextLine();
                FileWriter writer = new FileWriter("C:/JavaIO/Error/Error.txt", true);
                bufferWriter = new BufferedWriter(writer);
                bufferWriter.newLine();
                bufferWriter.write(message);
                bufferWriter.close();
                writer.close();
            } catch (IOException error) {
                // handle
            } catch (SecurityException error){
                // handle
            }
        }
    }
    
    public static void main(String[] args){
        IO io = new IO();
        io.appendToFile();
    }
}
