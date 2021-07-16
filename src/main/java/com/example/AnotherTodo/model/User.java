package com.example.AnotherTodo.model;

import com.example.AnotherTodo.services.DateTimeParser;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.ParseException;

public class User {
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String phone;
    private String telegram;
    private Timestamp birthday;
    private Timestamp registrationDate;

    public User() {
    }

    public User(JSONObject jObj) throws ParseException {
        this.username = jObj.getString("username");
        this.password = jObj.getString("password");
        this.firstname = jObj.getString("firstname");
        this.surname = jObj.getString("surname");
        this.email = jObj.getString("email");
        this.phone = jObj.getString("phone");
        this.telegram = jObj.getString("telegram");
        this.birthday = DateTimeParser.parseString(jObj.getString("birthday"));
        this.registrationDate = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTelegram() {
        return telegram;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public String getPassword() {
        return password;
    }
}


