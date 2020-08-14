package com.example.springredis.ioc.propertyeditor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sun.rmi.runtime.Log;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ljj
 * @version sprint 24
 * @className DatePropertyEditor
 * @description 日期类型转换类
 * @date 2020-07-27 20:10:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DatePropertyEditor extends PropertyEditorSupport {
    private String datePattern;

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        Date dateValue;
        try {
            dateValue = dateFormat.parse(text);
        }catch (ParseException e){
            dateValue = null;
        }
        setValue(dateValue);
    }
}
