package com.example.AnotherTodo.services;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonService {
    public static JSONObject getJsonFromServletRequest(HttpServletRequest request) throws IOException, JSONException {
        StringBuilder jsonString = new StringBuilder();
        String jsonToken;

        BufferedReader reader = request.getReader();
        while ((jsonToken = reader.readLine()) != null){
            jsonString.append(jsonToken);
        }
        return new JSONObject(jsonString.toString());
    }
}
