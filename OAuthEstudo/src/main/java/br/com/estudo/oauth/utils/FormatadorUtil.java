package br.com.estudo.oauth.utils;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FormatadorUtil{

    public static String encryptMD5(String text) {
          if(text == null){
              return null;
          }
          return encryptMD5(text.getBytes());
    }

    public static String encryptMD5(byte[] text) { 
           try {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        md.update(text);
                        BigInteger hash = new BigInteger(1, md.digest());
                        return org.apache.commons.lang.StringUtils.leftPad(hash.toString(16), 32, '0');
                } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                }

    }

}