package com.example.AnotherTodo.controllers;

import com.example.AnotherTodo.daos.UserDAO;
import com.example.AnotherTodo.model.User;
import com.example.AnotherTodo.services.JsonService;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
        userDAO.createTableIfAbsent();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath()+"/register.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonRequest = null;
        User user = null;

        try {
            jsonRequest = JsonService.getJsonFromServletRequest(request);
            user = new User(jsonRequest);
            userDAO.insertToDb(user);
            response.setStatus(200);
        } catch (IOException e) {
            //TODO: logging IO Exception
            System.out.println(e.getMessage());
            response.setStatus(400);
        } catch (JSONException e) {
            //TODO: logging JSON Exception
            System.out.println(e.getMessage());
            response.setStatus(400);
        } catch (ParseException e) {
            //TODO: logging JSON Exception
            System.out.println(e.getMessage());
            response.setStatus(400);
        }
    }
}
