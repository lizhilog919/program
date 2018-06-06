package com.test.demo.algorithm;

import java.util.HashMap;

public class StrCompareUtil {

    /**
     * KMP
     */
    public static boolean kmp(String parent, String child){
        if(child.length() > parent.length()){
            throw new IllegalArgumentException("second length must be shorter than first");
        }
        int n = parent.length() - child.length();
        for(int i=0; i<n; i++){

        }
        return true;
    }

    /**
     * sunday
     */
    public static int sunday(String parent, String child){
        if(child.length() > parent.length()){
            throw new IllegalArgumentException("second length must be shorter than first");
        }
        int n = parent.length() - child.length();
        int index = 0;
        int c_index = 0;
        int result_index = -1;
        HashMap<Character, Integer> childMap = new HashMap<>();
        for(int i=child.length()-1;i>=0;i--){
            if(!childMap.containsKey(child.charAt(i))){
                childMap.put(child.charAt(i), i);
            }
        }
        while (index <= parent.length()-1){
            if(child.charAt(c_index) == parent.charAt(index)){
                if(c_index + 1 == child.length()){
                   result_index = index - child.length() + 1;
                   break;
                }else {
                    c_index ++;
                    index ++;
                }
            }else{
                if(index == n){
                    break;
                }
                int f_index= index + child.length() - c_index;
                char last = parent.charAt(f_index);
                if(childMap.containsKey(last)){
                    index = index - c_index + child.length() - childMap.get(last);
                }else {
                    index = f_index + 1;
                }
                c_index = 0;
            }
        }
        return result_index;
    }

    public static void main(String[] args){
        String parent = "csjesdffbfzkbfesvbsejfb";
        String child = "ff";
        System.out.print(sunday(parent, child));
    }


}
