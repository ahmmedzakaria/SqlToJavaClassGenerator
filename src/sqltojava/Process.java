/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltojava;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import sqltojava.model.ClassField;

/**
 *
 * @author Zakaria
 */
public class Process {
    
    List<Path> files ;
    List<ClassField> fieldList =new ArrayList();
    StringBuffer stringBuffer = null;
    StringBuffer classContent = new StringBuffer();
    String line=null;
    String className;
    
    public void createClassFields(){
        fieldList.forEach(field->{
            classContent.append(field.getDataType()).append(" ")
                    .append(field.getFieldName()).append("\n");
        });
        System.out.println(classContent);
    }        
       
    public void read() throws FileNotFoundException, IOException{
        BufferedReader bufferedReader = new BufferedReader
                    (new FileReader(files.get(0).toString()));

            
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer = new StringBuffer(line);
                String s = stringBuffer.toString().trim().replaceFirst(",", "");
                List<String> words = Arrays.asList(s.split(" "));
                //words = words.stream().filter(e->!e.trim().equals("")).collect(Collectors.toList());
                //System.out.println("words"+Arrays.asList(words));
                
               // Arrays.asList(words).forEach(word->{System.out.println(word);});
               if(words.size() <2) {
                   //System.out.println("Less then 2: "+s);
                   continue;
               }
                if(words.get(0).equals("--")) {
                   continue;
               }
                if(words.get(0).equals(")")) {
                   continue;
               }
                 if(words.get(0).equals("(")) {
                   continue;
               }
                  if(words.get(0).toUpperCase().equals("CONSTRAINT")) {
                   continue;
               }
                  if(words.get(0).toUpperCase().equals("CREATE")) {
                      className = getPascalCase(words.get(2).replace("public.", ""));
                     // System.out.println("className: "+className);   
                   continue;
               } 
                ClassField field = new ClassField();
                try {
                field.setFieldName(getCamaleCase(words.get(0).trim()));
                field.setSqlFieldName(words.get(0).trim());
               // field.setDataType(getSqlDataType(words));               
                field.setDataType(Mapper.getJavaDataType(getSqlDataType(words)).getDataType());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Exception: "+field);
                }
                fieldList.add(field);
            }
            bufferedReader.close();
            //fieldList.forEach(System.out::println);
    }
    public void loadAllFiles() throws IOException{
       files = Files.list(Paths.get("resource")).collect(Collectors.toList());      
       files.forEach(System.out::println);      
    }
    public String getCamaleCase(String str){
        return StringUtils.decapitalize(getPascalCase(str));
    }
    
     public String getPascalCase(String str){
        StringBuffer sb = new StringBuffer();
        List<String> words = Arrays.asList(str.split("_"));
        if(words.size()>0){
            words.forEach(word->{
            sb.append(StringUtils.capitalize(word));
        });
        }
        return sb.toString();
    }
    
    public String getSqlDataType(List<String> lineWords){
        List<String> words = new ArrayList(4);
        if(lineWords.size() > 2){
            words.add(lineWords.get(1).trim());
            words.add(lineWords.get(2).trim());
            if(words.get(0).equals("character") && words.get(1).equals("varying")){
                return new StringBuffer().append(words.get(0))
                    .append(" ").append(words.get(1))
                    .toString();
            }
            if(words.get(0).equals("double") && words.get(1).equals("precision")){
                return new StringBuffer().append(words.get(0))
                    .append(" ").append(words.get(1))
                    .toString();
            }
            
        }
        if (lineWords.size() > 4){
            words.add(lineWords.get(3).trim());
            words.add(lineWords.get(4).trim());
            if(words.get(0).equals("timestamp") && words.get(1).equals("without")){
                return new StringBuffer().append(words.get(0))
                    .append(" ").append(words.get(1))
                    .append(" ").append(words.get(2))
                    .append(" ").append(words.get(3))
                    .toString();
            }
            
        }
        
        return lineWords.get(1);
    }
      
}
