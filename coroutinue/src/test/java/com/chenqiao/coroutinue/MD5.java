package com.chenqiao.coroutinue;

import java.security.MessageDigest;

/**
 * Created by chenqiao on 2020/4/27.
 * e-mail : mrjctech@gmail.com
 */
public class MD5 {


    private static final char hexDigits[] =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String toHexString(byte[] bytes) {
        if (bytes == null) return "";
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(hexDigits[(b >> 4) & 0x0F]);
            hex.append(hexDigits[b & 0x0F]);
        }
        return hex.toString();
    }

    /**
     * MD5加密
     *
     * @param s 明文
     * @return MD5密文
     */
    public final static String MD5(String s) {
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            return toHexString(md);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
