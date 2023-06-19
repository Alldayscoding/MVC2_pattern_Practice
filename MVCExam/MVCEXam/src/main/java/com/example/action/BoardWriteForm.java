package com.example.action;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardWriteForm implements Action {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardVO bVo= new BoardVO();
        bVo.setName(request.getParameter("name"));
        bVo.setPass(request.getParameter("pass"));
        bVo.setEmail(request.getParameter("email"));
        bVo.setTitle(request.getParameter("title"));
        bVo.setContent(request.getParameter("content"));

        BoardDAO bDao = BoardDAO.getInstance();
        int result = bDao.inserBoard(bVo);

    }
}
