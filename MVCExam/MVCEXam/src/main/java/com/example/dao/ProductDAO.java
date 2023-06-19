package com.example.dao;

import com.example.dto.ProductVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private ProductDAO() {}
    private static ProductDAO instance = new ProductDAO();
    public static ProductDAO getInstance() {return instance;}

    //c Read u D
    public List<ProductVO> selectAllProducts() {
        //최근 등록한 상품 먼저 출력하기

        String sql = "Select * from product order by code desc";
        List<ProductVO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn= DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                ProductVO pVo = new ProductVO();
                pVo.setCode(rs.getInt("code"));
                pVo.setName(rs.getString("name"));
                pVo.setPrice(rs.getInt("price"));
                pVo.setPictureUrl(rs.getString("pictureUrl"));
                pVo.setDescription(rs.getString("description"));
                list.add(pVo);
            }
        }catch (Exception e){e.printStackTrace();}
        finally {
            DBManager.close(conn,pstmt,rs);
        }
    return list;
    }

}
