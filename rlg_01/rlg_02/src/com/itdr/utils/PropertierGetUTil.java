package com.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PropertierGetUTil {
    public  static String getValue (String key){
        Properties ps=new Properties();
        InputStream in =PropertierGetUTil.class.getClassLoader().getResourceAsStream("/const.properties");
        try {
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String valus =ps.getProperty(key);
        return valus;
    }

    }

