package com.example.action;

import com.example.action.Action;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardWriteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="board/boardWrite.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
