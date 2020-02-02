/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classGenerateDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Zakaria
 */
public class ListOfAllFilesInDirectory {
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("."))
        .forEach(System.out::println);
    }
}
