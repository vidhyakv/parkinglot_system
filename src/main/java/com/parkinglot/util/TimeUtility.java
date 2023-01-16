package com.parkinglot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtility {

    public static LocalDateTime convertStringToLocalDateTime(String date,String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date+" "+time, formatter);
        return localDateTime;
    }
}
