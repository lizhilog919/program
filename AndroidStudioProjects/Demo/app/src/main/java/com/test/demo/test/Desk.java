package com.test.demo.test;

import android.content.Intent;

import java.io.Serializable;

/**
 * Created by lizhi
 * 17-3-7
 */
public class Desk implements Serializable {

    Desk(){
        Intent intent = new Intent();
    }

    void c() throws JException, DException {
    }

    public static void main(String[] args){
        try {
            new Css().c();
        } catch (JException e) {
            e.printStackTrace();
        } catch (DException e) {
            e.printStackTrace();
        }
    }

    public static class Css extends Desk{

        void c() throws DException, JException {
            super.c();
            throw new DException();
        }
    }

    class JException extends Exception{
    }

    class DException extends Exception{

    }

}
