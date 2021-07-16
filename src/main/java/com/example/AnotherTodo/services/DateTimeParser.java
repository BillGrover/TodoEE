package com.example.AnotherTodo.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser {
    public static Timestamp parseString(String date, String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parsedDate = dateFormat.parse(date + " " + time);
        return new Timestamp(parsedDate.getTime());
    }

    public static Timestamp parseString(String date) throws ParseException {
        if (date == null || date.equals("")) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            return new Timestamp(parsedDate.getTime());
        }
    }
}
