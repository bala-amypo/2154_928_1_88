package com.example.demo.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/hello-servlet") // REQUIRED MAPPING FOR ASSIGNMENT & TESTING
public class SimpleHelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)   // ⬅️ PUBLIC FIX
            throws IOException {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Hello from Simple Servlet");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  // ⬅️ ADDED FOR SAFETY
            throws IOException {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("POST request received");
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet returns a plain text message";
    }
}
