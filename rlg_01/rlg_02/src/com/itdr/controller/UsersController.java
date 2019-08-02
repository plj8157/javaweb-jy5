package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.PathUitl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/manage/user/*")

public class UsersController extends HttpServlet {
    private UserService uc=new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
//list.do
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求路径
String pathInfo=  request.getPathInfo();
        String path = PathUitl.getPath(pathInfo);
        //统一返回对象
        ResponseCode rs=null;
//判断是什么请求
        switch (path){
            case "list":
                rs=listDo(request);
                break;
            case "login":
                rs=loginDo(request);
                break;
            case "disableuserDo":
                rs=disableuserDo(request);
                break;
            case "SelectUsers":
                rs=SelectUsers(request);
        }



//
//        UserService uc=new UserService();//业务层对象
//      rs= uc.selectAll(pageSize,pageNum);//业务层的查询所有
//返回响应数据
         response.getWriter().write(rs.toString());

    }
    //获取所有信息
    private ResponseCode listDo(HttpServletRequest request){
        ResponseCode rs=new ResponseCode();
        HttpSession session=request.getSession();
        Users users=(Users )session.getAttribute("user");
        if(users==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作");
            return rs;
        }
        if(users.getType()!=1){
            rs.setStatus(2);
            rs.setMag("没有权限");
            return rs;
        }
        //获取参数
        String pageSize=request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");

         rs = uc.selectAll(pageSize, pageNum);
        return rs;
    }
    //用户登录
    private ResponseCode loginDo(HttpServletRequest request){
        //获取参数
        String username=request.getParameter("username");
        String password = request.getParameter("password");

     ResponseCode rs=  uc.selectOne(username,password);
     //获取session对象
        HttpSession session=request.getSession();
        session.setAttribute("user",rs.getData());
        return rs;
    }
    //禁用
    private ResponseCode disableuserDo(HttpServletRequest request){
        String uid =request.getParameter("uid");//获取参数

        ResponseCode rs=  uc.selectOne(uid);
//        //获取session对象
        HttpSession session=request.getSession();
        session.setAttribute("user",rs.getData());
        return rs;
    }
   //根据用户id查找一个全部信息
   private ResponseCode SelectUsers(HttpServletRequest request){
       String uid =request.getParameter("uid");//获取参数
       ResponseCode rs=  uc.UserSelect(uid);
//       //获取session对象
       HttpSession session=request.getSession();
       session.setAttribute("user",rs.getData());
       return rs;
   }
//根据用户id修改信息

}

