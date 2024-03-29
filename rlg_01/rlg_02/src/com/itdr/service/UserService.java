package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UsersDao;
import com.itdr.pojo.Users;

import java.util.Collection;
import java.util.List;

public class UserService {
    private      UsersDao ud=new UsersDao ();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if (pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null||pageNum.equals("")){
            pageNum="1";
        }

       List<Users>li= ud.selectAll(pageSize,pageNum);
       ResponseCode rs=new ResponseCode();
       rs.setStatus(0);
       rs.setData(li);
        return rs;
    }
//用户登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if (username == null || username.equals("") || password == null || password.equals("")) {
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        //查找是否有这个用户
        Users u=ud.selectOne(username,password);
//如果用户不存在
        if(u==null){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        if(u.getType()!=1){
            rs.setStatus(2);
            rs.setMag("没有权限");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);

        return rs;
    }
//用户禁用
    public ResponseCode selectOne(String uids) {
        ResponseCode rs = new ResponseCode();
        if (uids == null||uids.equals("")) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //字符串转数字
        Integer uid=null;
        try{
           uid= Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
        }
        //查找是否有这个用户
        Users u=ud.selectOne(uid);
//如果用户不存在
        if(u==null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        if(u.getStats()!=0){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }
        //禁用用户
     int row= ud.uodateByUid(uid);
       if(row<=0){
           rs.setStatus(106);
           rs.setMag("用户禁用更新失败");
           return rs;
       }
       rs.setStatus(0);
       rs.setData(row);
        return rs;
    }
    //查找用户
    public ResponseCode UserSelect(String uids) {
        ResponseCode rs = new ResponseCode();
        if (uids == null||uids.equals("")) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //字符串转数字
        Integer uid=null;
        try{
            uid= Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
        }
        //查找是否有这个用户
        Users u=ud.selectOne(uid);
//如果用户不存在
        if(u==null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }

}
