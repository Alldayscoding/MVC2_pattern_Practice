package com.example.action;

import com.example.dao.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardDelete implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "BoardServlet?command=board_list";
        String num = request.getParameter("num");
        BoardDAO bDao = BoardDAO.getInstance();
        bDao.deleteBoard(num);
        response.sendRedirect(url);
    }
}
