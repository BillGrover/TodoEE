package com.example.AnotherTodo.controllers;

import com.example.AnotherTodo.model.User;
import com.example.AnotherTodo.services.JsonService;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "AuthController", urlPatterns= {"/auth/login", "/auth/logout"})
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath().substring(6);

        if (action.equals("login")) {
            goToLoginJsp(req, resp);
        } else {
            doLogout(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getServletPath().substring(6);
        try {
            switch (action) {
                case "logout":
                    doLogout(req, resp);
                    break;
                case "login":
                    doLogin(req, resp);
                    break;
                default:
                    goToLoginJsp(req, resp);
                    break;
            }
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            resp.setStatus(400);
        }
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("тут делается логин");
        JSONObject jsonRequest;
        User userForAuth;

        try{
            jsonRequest = JsonService.getJsonFromServletRequest(req);
            userForAuth = new User(jsonRequest);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("тут делается логаут");
//        final HttpSession session = req.getSession();
//
//        session.removeAttribute("password");
//        session.removeAttribute("login");
//        session.removeAttribute("role");
//
//        resp.sendRedirect(super.getServletContext().getContextPath());
    }

    private void goToLoginJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
