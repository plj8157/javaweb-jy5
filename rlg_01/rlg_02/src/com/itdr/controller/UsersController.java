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
                listDo(request,response);
                break;
            case "login":
               loginDo(request,response);
                break;
            case "disableuser":
                disableuserDo(request);
                break;
            case "SelectUsers":
                SelectUsers(request);
        }



//
//        UserService uc=new UserService();//业务层对象
//      rs= uc.selectAll(pageSize,pageNum);//业务层的查询所有
//返回响应数据
//         response.getWriter().write(rs.toString());

    }

    //获取所有信息
    private void listDo(HttpServletRequest request,HttpServletResponse response){
//        ResponseCode rs=new ResponseCode();

        //获取参数
        String pageSize=request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");

        ResponseCode rs = uc.selectAll(pageSize, pageNum);
request.setAttribute("uli",rs);
        try {
            request.getRequestDispatcher("/userlist.do.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return rs;
    }
    //用户登录
    private void  loginDo(HttpServletRequest request,HttpServletResponse response)  {
        //获取参数
        String username=request.getParameter("username");
        String password = request.getParameter("password");

     ResponseCode rs=  uc.selectOne(username,password);
//     //获取session对象
        HttpSession session=request.getSession();
        session.setAttribute("user",rs.getData());
        try {
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //禁用
    private ResponseCode disableuserDo(HttpServletRequest request){
        String uid =request.getParameter("uid");//获取参数

        ResponseCode rs=  uc.selectOne(uid);
////        //获取session对象
//        HttpSession session=request.getSession();
//        session.setAttribute("user",rs.getData());
        return rs;
    }
   //根据用户id查找一个全部信息
   private ResponseCode SelectUsers(HttpServletRequest request){
       String uid =request.getParameter("uid");//获取参数
       ResponseCode rs=  uc.UserSelect(uid);
////       //获取session对象
//       HttpSession session=request.getSession();
//       session.setAttribute("user",rs.getData());
       return rs;
   }
//根据用户id修改信息

}

