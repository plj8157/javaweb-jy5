package com.itdr.dao;

import com.itdr.pojo.Commodity;
import com.itdr.utils.PoolUitl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

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
}
