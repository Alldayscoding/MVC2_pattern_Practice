package com.example.controller;

import java.io.IOException;
import com.example.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


//DispatcherServlet. Front Controller

@WebServlet(name = "BoardServlet", value = "/BoardServlet")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
//        System.out.println(command);

        ActionFactory af = ActionFactory.getInstance();
        Action action = af.getAction(command); //new BoardListAction();

        if(action != null){
            action.execute(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}