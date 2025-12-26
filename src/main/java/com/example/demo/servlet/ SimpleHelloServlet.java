package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Hello from Simple Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // Handle POST requests; return 405 if not supported
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("POST request received");
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet - A basic test servlet";
    }
}
