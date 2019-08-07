package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.CommodityService;
import com.itdr.utils.PathUitl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/manage/product/*")
public class CommodityController extends HttpServlet {
    private CommodityService cs=new CommodityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求路径
        String pathInfo=  request.getPathInfo();
        String path = PathUitl.getPath(pathInfo);
        //统一返回对象
        ResponseCode rs=null;
//判断是什么请求
        switch (path){
            case  "detail":
         rs=detailDo(request);
         break;
            case "list":
                rs=listDo(request);
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }
//获取商品列表
    private ResponseCode listDo(HttpServletRequest request) {
        //获取参数
        String pageSize=request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");

        ResponseCode rs = cs.selectAll(pageSize, pageNum);
        return rs;

    }

    //获取商品详情
    private ResponseCode detailDo(HttpServletRequest request){

        //获取参数
        String productId=request.getParameter("productId");

        ResponseCode  rs=cs.selectOne(productId);
        //获取session对象
//        HttpSession session=request.getSession();
//        session.setAttribute("product",rs.getData());
        return rs;
    }
}
