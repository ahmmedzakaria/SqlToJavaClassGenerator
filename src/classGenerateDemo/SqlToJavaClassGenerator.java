/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classGenerateDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Zakaria
 */
public class SqlToJavaClassGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

            readBuffer();
    }
    
    static void readBuffer() throws FileNotFoundException, IOException{
            
            List<JavaMapper> fieldList =new ArrayList();
            StringBuffer stringBuffer = null;
            String line=null;
            BufferedReader bufferedReader = new BufferedReader
                    (new FileReader("resource\\sqlfile.txt"));

            
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer = new StringBuffer(line);
                String words[] = stringBuffer.toString().split(" ");
                
                //Arrays.asList(words).forEach(word->{System.out.println(word);});
                JavaMapper mapper = new JavaMapper();
                mapper.setFieldName(getConvertedFiledName(words[0]));
                mapper.setDataType(getConvertedDataType(words[1]));
                fieldList.add(mapper);
            }
            bufferedReader.close();
            fieldList.forEach(System.out::println);
        } 
          
        static String getConvertedFiledName(String sqlName){
            
            return sqlName;
        }
        static String getConvertedDataType(String  dataTyp){
            
            return dataTyp;
        }
    
}
