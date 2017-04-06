package com.test.demo.encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

/**
 * Created by Li Zhi
 * 2017/4/4.
 */

public interface Secret {

    String encryption(String origin) throws Exception;
    String decryption(String origin) throws Exception;
}
