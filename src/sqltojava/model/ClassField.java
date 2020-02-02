/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltojava.model;

import java.util.List;

/**
 *
 * @author Zakaria
 */
public class ClassField {
    private String fieldName;
    private String sqlFieldName;
    private String dataType;
    private List<FieldAnnotation> annotatios;
    private String rightComment;
    private String topComment;

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

    public List<FieldAnnotation> getAnnotatios() {
        return annotatios;
    }

    public void setAnnotatios(List<FieldAnnotation> annotatios) {
        this.annotatios = annotatios;
    }

    public String getRightComment() {
        return rightComment;
    }

    public void setRightComment(String rightComment) {
        this.rightComment = rightComment;
    }

    public String getTopComment() {
        return topComment;
    }

    public void setTopComment(String topComment) {
        this.topComment = topComment;
    }

    public String getSqlFieldName() {
        return sqlFieldName;
    }

    public void setSqlFieldName(String sqlFieldName) {
        this.sqlFieldName = sqlFieldName;
    }

    @Override
    public String toString() {
        return "ClassField{" + "fieldName=" + fieldName + ", sqlFieldName=" + sqlFieldName + ", dataType=" + dataType + ", annotatios=" + annotatios + ", rightComment=" + rightComment + ", topComment=" + topComment + '}';
    }

    
    
    
}
