package com.bitsco.vks.utils;

import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;


public class Md5 {
    private static MessageDigest md;
    private static String algorithm = "MD5";
    private static String provider = "SUN";
    // hieutt10 21/02/2013
    private static String charset = "UTF-8";
    private static String presalt = "<PWD>";
    private static String sufsalt = "</PWD>";

    // Ma hoa

    public static String encode(String stPassword_) {
        try {
            md = MessageDigest.getInstance(algorithm, provider);

            if (md != null) {
                md.reset();
                return processPassword(stPassword_);
            }
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Run

    protected static String processPassword(String stPassword_) throws IOException {
        //        StringReader sr = null;
        //        StringBuffer sbPassword = new StringBuffer();
        //        int cod = 0;
        //        md.update(stPassword_.getBytes());
        //
        //        sr = new StringReader(new String(md.digest()));
        //
        //        while ((cod = sr.read()) != -1) {
        //            sbPassword.append(Integer.toHexString(cod));
        //        }
        //        return sbPassword.toString();
        String s = presalt + stPassword_ + sufsalt;
        md.update(s.getBytes(charset));
        byte[] byteData = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
