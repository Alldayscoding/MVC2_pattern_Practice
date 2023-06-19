package com.example.dao;

import com.example.dto.BoardVO;
import util.DBManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
 //CRUD 여기다가
    private static BoardDAO instance = new BoardDAO();
    private BoardDAO(){}
    public static BoardDAO getInstance() {return instance;}

    //c READ u d
    public List<BoardVO> selectAllBoard() {

        List<BoardVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "SELECT * FROM board";

        try {

            conn= DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setPass(rs.getString("pass"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setReadCount(rs.getInt("readcount"));
                vo.setWriteDate(rs.getTimestamp("writedate"));

                list.add(vo);
            }

        }catch ( Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int inserBoard(BoardVO bVo) {
    int result =0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO board(num, pass, name, email, title, content) VALUES(board_seq.nextval, ?,?,?,?,?)";

        try {
            conn=DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bVo.getPass());
            pstmt.setString(2, bVo.getName());
            pstmt.setString(3, bVo.getEmail());
            pstmt.setString(4, bVo.getTitle());
            pstmt.setString(5, bVo.getContent());
            result = pstmt.executeUpdate();

        }catch (Exception e ){
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }

        return result;
    }

    public BoardVO selectOneBoardByNum(int movieKey) {

        BoardVO bVo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "SELECT * FROM board where num=?";

        try {

            conn= DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,movieKey);
            rs=pstmt.executeQuery();

            if (rs.next()) {
                bVo = new BoardVO();
                bVo.setNum(rs.getInt("num"));
                bVo.setPass(rs.getString("pass"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadCount(rs.getInt("readcount"));
                bVo.setWriteDate(rs.getTimestamp("writedate"));
            }

        }catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn,pstmt,rs);
        }

    return bVo;
    }

    public void updateReadCount(int movieKey) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "UPDATE BOARD SET readcount = readcount+1 where num =?";

        try {

            conn= DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,movieKey);
            pstmt.executeUpdate();

        }catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn,pstmt);
        }
    }

    public BoardVO pwdCheck(String num, String password) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "SELECT * from board where num=?";
        BoardVO bVo = null;
        try {

            conn= DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(num));
            rs = pstmt.executeQuery();

            if(rs.next()){
                bVo = new BoardVO();
                bVo.setNum(rs.getInt("num"));
                bVo.setPass(rs.getString("pass"));
                bVo.setName(rs.getString("name"));
                bVo.setEmail(rs.getString("email"));
                bVo.setTitle(rs.getString("title"));
                bVo.setContent(rs.getString("content"));
                bVo.setReadCount(rs.getInt("readcount"));
                bVo.setWriteDate(rs.getTimestamp("writedate"));
            }

        }catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn,pstmt);
        }
        return bVo;
    }

    public void updateBoard(BoardVO bVo) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "UPDATE BOARD SET pass=?, name=?, email=?, title=?, content=? where num =?";

        try {

            conn= DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,bVo.getPass());
            pstmt.setString(2,bVo.getName());
            pstmt.setString(3,bVo.getEmail());
            pstmt.setString(4, bVo.getTitle());
            pstmt.setString(5, bVo.getContent());
            pstmt.setInt(6, bVo.getNum());
            pstmt.executeUpdate();

        }catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn,pstmt);
        }


    }
}
