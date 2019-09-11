package kr.or.ddit.type;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDatePropertyEditor implements PropertyEditorRegistrar {

   //문자열 --> java.util.Date
   @Override
   public void registerCustomEditors(PropertyEditorRegistry registry) {
      
      registry.registerCustomEditor(Date.class, 
            new CustomDateEditor(
                  new SimpleDateFormat("yyyy-MM-dd"), true));
      
   }

}