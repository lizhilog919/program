package com.test.demo.encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by Li Zhi
 * 2017/4/4.
 */

public class RSA implements Secret {
    @Override
    public String encryption(String origin) throws Exception {
        RsaKey rsaKey = RsaKey.getInstance();
        Cipher cipher = Cipher.getInstance("rsa");
        cipher.init(Cipher.ENCRYPT_MODE, rsaKey.getPrivateKey(),new SecureRandom());
        byte[] cipherData = cipher.doFinal(origin.getBytes());
        return String.valueOf(cipherData);
    }

    @Override
    public String decryption(String origin) throws Exception {
        RsaKey rsaKey = RsaKey.getInstance();
        Cipher cipher = Cipher.getInstance("rsa");
        cipher.init(Cipher.DECRYPT_MODE,rsaKey.getPublicKey(),new SecureRandom());
        byte[] data = cipher.doFinal(origin.getBytes());
        return String.valueOf(data);
    }
}
