package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/simple-status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {   // <-- public, NOT protected
        resp.setContentType("text/plain");
        resp.setStatus(200);
        resp.getWriter().write("SaaS User Role Permission Manager is running");
    }
}
