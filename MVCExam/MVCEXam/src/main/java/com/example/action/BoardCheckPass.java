package com.example.action;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardCheckPass implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = null;
        String num = request.getParameter("num");
        String password = request.getParameter("pass");

        BoardDAO bDao = BoardDAO.getInstance();
        BoardVO bVo = bDao.pwdCheck(num, password);

        if(bVo.getPass().equals(password)){
            url = "board/checkSuccess.jsp";
        }
        else url = "board/boardList.jsp";

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
