package com.core.date;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author sunil
 */
public class CurrentDate {
    
    @Test
    public void main()  {
        Timestamp dTime = new Timestamp(new Date().getTime());
        
        //2008-07-18 11:53:36.258
        
        Calendar cal = new GregorianCalendar();
        
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd:hh_mm");
        DateFormat _format = new DateFormat();
        
        String strDate = format.format(new Date());        
        
        System.out.println("-------------> " + strDate);
        
        
    }

}