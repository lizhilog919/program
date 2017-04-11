package com.test.kotlin

/**
 * Created by Li Zhi
 * 2017/4/6.
 */
class Test(var args: String) {

    fun test():Int{
        var result:Int;
        when(args.length){
            0 -> result = 0
            1 -> result = 1
            else -> result = 2
        }
        return result;
    }
}