package com.example.AnotherTodo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Маппинг этого сервлета определен в web.xml

public class WebXmlMappedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("console");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Маппинг этого сервлета определен в web.xml" + "</h1>");
        out.println("</body></html>");
    }
}
