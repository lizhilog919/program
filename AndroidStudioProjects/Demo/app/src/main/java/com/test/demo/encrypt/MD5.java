package com.test.demo.encrypt;

import com.test.demo.common.NoCatchException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;

/**
 * Created by Li Zhi
 * 2017/4/4.
 */

public class MD5 implements Secret {
    @Override
    public String encryption(String origin) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] data = md5.digest(origin.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b : data) {
            String toHexStr = Integer.toHexString(b & 0xff);
            builder.append(toHexStr.length() == 1? "0"+toHexStr:toHexStr);
        }
        return builder.toString();
    }

    @Override
    public String decryption(String origin) {
        throw new NoCatchException(origin);
    }
}
