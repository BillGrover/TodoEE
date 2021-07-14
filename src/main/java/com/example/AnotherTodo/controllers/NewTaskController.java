package com.example.AnotherTodo.controllers;

import com.example.AnotherTodo.services.JsonService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewTaskController", value = "/newTask")
public class NewTaskController extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doing get");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonRequest = JsonService.getJsonFromServletRequest(request);



    }

    public void destroy() {
    }

}
