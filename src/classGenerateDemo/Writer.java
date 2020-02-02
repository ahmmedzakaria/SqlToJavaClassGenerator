/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classGenerateDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Zakaria
 */
public class Writer {
        public static void main(String[] args) throws IOException {

            String fileName = "Test";
            String ext = ".java";
            String path = "javaclasses\\";
            String fileNameWithPath =path + fileName +ext;
            String content = "public class "+fileName+"{ }";
            File file = new File(fileNameWithPath);

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
            
            writeToFile(fileNameWithPath,content);
       
    }
        
       static void writeToFile(String fileName, String content) throws IOException{
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();

            System.out.println("Done");
        }
}
