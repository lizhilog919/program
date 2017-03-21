package com.test.demo.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Li Zhi
 * 2017/3/15.
 */

public class PatternTest {
    public static void main(String[] args){

        String origin = "q12m,232,34sdse,sfsq,WEWDc,dfd";
        String pattern = "\\d*[a-zA-Z]+";
        String[] strs = origin.split(",");
        for (String str : strs) {
            System.out.println(str.matches(pattern));
        }
        System.out.println(" ");
        Pattern pattern1 = Pattern.compile(pattern);
        for (String str : strs) {
            Matcher matcher = pattern1.matcher(str);
            boolean isMatcher = matcher.find(4);//从第四个位置开始搜索
            System.out.println(matcher.matches());
        }

    }
}
