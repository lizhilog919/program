package com.test.demo.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.KeyGenerator;

/**
 * Created by Li Zhi
 * 2017/4/4.
 */

public class RsaKey {

    private KeyPair mKeyPair;

    private static RsaKey sInstance = null;

    private RsaKey(){
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("rsa");
            generator.initialize(1024);
            mKeyPair = generator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static RsaKey getInstance(){
        if(sInstance == null){
            synchronized (RsaKey.class){
                if(sInstance == null){
                    sInstance = new RsaKey();
                }
            }
        }
        return sInstance;
    }

    public PublicKey getPublicKey(){
        return mKeyPair.getPublic();
    }

    public PrivateKey getPrivateKey(){
        return mKeyPair.getPrivate();
    }
}
