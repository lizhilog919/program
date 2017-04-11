package com.test.kotlin

/**
 * Created by Li Zhi
 * 2017/4/6.
 */
class Child(size:Int, name: String) : Parent(name) {

    override fun hashCode(): Int {
        return super.hashCode()
    }
}