package projectTests;

import java.io.*;
import java.util.Scanner;

public class FileExampleClass {
    public FileExampleClass(String directory){
        try{
            if(new File(directory).isFile()) {
                Scanner scan = new Scanner(new File(directory), "UTF-8");


                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            }else{
                System.out.println("This file does not exist!");
            }

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was a problem :/");

        }
    }
}
