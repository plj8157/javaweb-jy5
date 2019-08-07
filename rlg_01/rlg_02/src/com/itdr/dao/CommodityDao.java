package com.itdr.dao;

import com.itdr.pojo.Commodity;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUitl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommodityDao {
    //根据商品id查找商品
    public Commodity selectOne(Integer sid) {
            QueryRunner qr=new QueryRunner(PoolUitl.getCom());
            String sql="select * from Commodity  where sid=?";
         Commodity c=null;
            try {
                c= qr.query(sql,new BeanHandler<Commodity>(Commodity.class ),sid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return c;
        }

    public List<Commodity> selectAll(String pageSize, String pageNum) {
        //获取连接池
        QueryRunner qr=new QueryRunner(PoolUitl.getCom());
        String sql="select * from Commodity ";
        List <Commodity> li=null;
        try {
            li=  qr.query(sql,new BeanListHandler<Commodity>(Commodity.class ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
