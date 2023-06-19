package com.example.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//DispatcherServlet?. Front controller
public interface Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
