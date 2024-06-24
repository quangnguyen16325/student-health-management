package com.mycompany.until;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

public class Encode {
    public static String toSHA1(String password) {
        String key = "ZmjjKK&TenZ&Something&f0rsakeN&Zellsis";
        String result = null;
        
        password = password + key;
        try {
            byte[] dataBytes = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
//    public static void main(String[] args) {
//        String test = "cuong123";
//        String pass = toSHA1(test);
//        System.out.println(pass);
//    }
}
