package com.example.demo.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class SimpleHelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.println("Hello from Simple Servlet");
        out.close();
    }
    
    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet returns a plain text hello message";
    }
}