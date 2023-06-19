package com.example.action;

import com.example.action.Action;
import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardViewAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int movieKey = Integer.parseInt(request.getParameter("num"));
        BoardDAO bDao = BoardDAO.getInstance();
        bDao.updateReadCount(movieKey);

        BoardVO bVo = bDao.selectOneBoardByNum(movieKey);
        String url = "board/boardView.jsp";

        request.setAttribute("board", bVo);
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
