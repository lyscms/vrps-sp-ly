package com.ly.vrps.common.util;

import java.io.UnsupportedEncodingException;

/**
 * 编码转换
 *
 * @author 10589
 * @date 2016/10/3
 * @time 21:33
 */
public class CodeConvert {



    public static String UTF_8ToGBK(String str){
        byte []temp = new byte[1024];
        String newStr = "";
        try {
            temp = str.getBytes();
            newStr = new String(temp,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }

    public static String UTF_8ToUTF_8(String str){
        byte []temp = new byte[1024];
        String newStr = "";
        try {
            temp = str.getBytes("GBK");
            newStr = new String(temp,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }
}
