package com.example.action;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BoardDAO bDao = BoardDAO.getInstance();
        BoardVO bVo = new BoardVO();

        String url = "BoardServlet?command=board_list";

        bVo.setNum(Integer.parseInt(request.getParameter("num")));
        bVo.setName(request.getParameter("name"));
        bVo.setPass(request.getParameter("pass"));
        bVo.setEmail(request.getParameter("email"));
        bVo.setTitle(request.getParameter("title"));
        bVo.setContent(request.getParameter("content"));
        bDao.updateBoard(bVo);

//        RequestDispatcher dis = request.getRequestDispatcher(url);
//        dis.forward(request, response);
        response.sendRedirect(url);
    }
}
