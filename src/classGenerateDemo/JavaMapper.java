/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classGenerateDemo;

/**
 *
 * @author Zakaria
 */
public class JavaMapper {
    private String fieldName;
    private String dataType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "JavaMapper{" + "fieldName=" + fieldName + ", dataType=" + dataType + '}';
    }
    
}
