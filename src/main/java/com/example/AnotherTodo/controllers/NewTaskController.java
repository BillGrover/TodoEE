package com.example.AnotherTodo.controllers;

import com.example.AnotherTodo.dbServices.TaskDbService;
import com.example.AnotherTodo.model.Task;
import com.example.AnotherTodo.services.JsonService;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "NewTaskController", value = "/newTask")
public class NewTaskController extends HttpServlet {
    private TaskDbService taskDbService;
    public void init() {
        taskDbService = new TaskDbService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doing get");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonRequest = null;
        Task task = null;

        try{
            jsonRequest = JsonService.getJsonFromServletRequest(request);
            task = new Task(jsonRequest);
            taskDbService.insertToDb(task);
            response.setStatus(200);
        }catch (IOException e){
            //TODO: logging IO Exception
            response.setStatus(400);
        } catch (JSONException e){
            //TODO: logging JSON Exception
            response.setStatus(400);
        } catch (ParseException e) {
            //TODO: logging JSON Exception
            response.setStatus(400);
        }

    }

//    public void destroy() {    }

}
