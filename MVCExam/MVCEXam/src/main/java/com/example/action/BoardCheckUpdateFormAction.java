package com.example.action;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardCheckUpdateFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "board/boardUpdate.jsp";
        int num = Integer.parseInt(request.getParameter("num"));

        BoardDAO bDao = BoardDAO.getInstance();
        bDao.updateReadCount(num);

        BoardVO bVo = bDao.selectOneBoardByNum(num);
        request.setAttribute("board", bVo);

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
