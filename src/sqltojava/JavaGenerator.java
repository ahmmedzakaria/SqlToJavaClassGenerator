/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltojava;

import java.io.IOException;

/**
 *
 * @author Zakaria
 */
public class JavaGenerator {
    
    
    public static void main(String[] args) throws IOException {
        Process process =new Process();
        process.loadAllFiles();
        process.read();
        process.createClassFields();
    }
}
