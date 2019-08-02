package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolUitl {
    public static  ComboPooledDataSource aa=new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
         return aa;
    }
}
