package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.CommodityDao;
import com.itdr.pojo.Commodity;
import com.itdr.pojo.Users;

import java.util.List;

public class CommodityService {
    private CommodityDao cd=new CommodityDao();
//查找商品
    public ResponseCode selectOne(String productId) {
        ResponseCode rs = new ResponseCode();
        if (productId == null||productId.equals("")) {
            rs.setStatus(Const.COMMODITY_PARAMETER_CODE);
            rs.setMag(Const.COMMODITY_PARAMETER_MSG);
            return rs;
        }
        //字符串转数字
        Integer sid=null;
        try{
            sid= Integer.parseInt(productId);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
        }
        //查找是否有这个商品
        Commodity c=cd.selectOne(sid);
        //如果s商品不存在
        if(c==null){
            rs.setStatus(Const.COMMODITY_NO_CODE);
            rs.setMag(Const.COMMODITY_NO_MSG);
            return rs;
        }
        rs.setStatus(0);
        rs.setData(c);
        return rs;
    }

    public ResponseCode selectAll(String pageSize, String pageNum) {
        if (pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null||pageNum.equals("")){
            pageNum="1";
        }

        List<Commodity> li= cd.selectAll(pageSize,pageNum);
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
}
