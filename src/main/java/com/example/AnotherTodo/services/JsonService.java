package com.example.AnotherTodo.services;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonService {
    public static String getJsonFromServletRequest(HttpServletRequest request) throws IOException {
        StringBuilder jsonString = new StringBuilder();
        String jsonToken;

        BufferedReader reader = request.getReader();
        while ((jsonToken = reader.readLine()) != null){
            jsonString.append(jsonToken);
        }
        return jsonString.toString();
    }
}
