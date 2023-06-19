package com.example.action;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;

public class BoardListAction implements Action{
//인터페이스는 인터페이스를 구현한 클래스를 객채로 가질 수 있으니까
    // Action은 BoardListAction
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/board/boardList.jsp";
        BoardDAO bDao = BoardDAO.getInstance();
        List<BoardVO> list = bDao.selectAllBoard();

        request.setAttribute("boardList", list);
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }


}
