package kr.or.ddit.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//문자열 -> javal.util.Date
public class CustomDateConverter implements Converter<String, Date>{

   //<property name="reg_dt" value="2019-07-08"/>
   @Override
   public Date convert(String source) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      try {
         sdf.parse(source);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      return null;
   }
   
}