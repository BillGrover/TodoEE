package com.example.AnotherTodo.model;

import com.example.AnotherTodo.services.DateTimeParser;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.ParseException;

public class Task {
    private long id;
    private String title;
    private Timestamp dateTime;
    private String description;

    public Task() {
    }

    public Task(JSONObject jObj) throws ParseException {
        this.title = jObj.getString("title");
        this.dateTime =
                DateTimeParser.parseString(
                        jObj.getString("date"),
                        jObj.getString("time"));
        this.description = jObj.getString("description");
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }
}
