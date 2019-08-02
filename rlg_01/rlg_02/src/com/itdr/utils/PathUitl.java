package com.itdr.utils;

public class PathUitl {
    public static String getPath(String path) {
        String sl = path.replace(".", "/");
        String[] sar = sl.split("/");
        return sar[1];

    }
}
