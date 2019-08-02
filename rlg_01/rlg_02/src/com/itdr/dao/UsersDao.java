package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUitl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class UsersDao {
    //查找所有
    public List<Users> selectAll(String pageSize, String pageNum) {
        //获取连接池
        QueryRunner qr=new QueryRunner(PoolUitl.getCom());
        String sql="select * from Users ";
        List <Users> li=null;
        try {
         li=  qr.query(sql,new BeanListHandler<Users>(Users.class ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//根据用户名和密码查找
    public Users selectOne(String username, String password) {
        QueryRunner qr=new QueryRunner(PoolUitl.getCom());
        String sql="select * from Users  where uname= ?and psd=?";
        Users u=null;
        try {
            u=  qr.query(sql,new BeanHandler<Users>(Users.class ),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
//根据ID查找用户
    public Users selectOne(Integer uid) {
        QueryRunner qr=new QueryRunner(PoolUitl.getCom());
        String sql="select * from Users  where id=?";
        Users u=null;
        try {
            u=  qr.query(sql,new BeanHandler<Users>(Users.class ),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
//根据id禁用
    public int uodateByUid(Integer uid) {
        QueryRunner qr=new QueryRunner(PoolUitl.getCom());
        String sql="update  Users set stats=1 where id=?";
        int row=0;
        try {
            row=  qr.update(sql,new BeanHandler<Users>(Users.class ),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
