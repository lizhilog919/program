package com.test.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        text.text = Test("1").test().toString();
        var num = arrayListOf<String>();
        num.add("a");
        num.add("v")
        num.add("advise");
        num.add("binder")
        num.add("abroad")
        var strs:String = "";
        num.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { strs += " " +it + "\n"; }
        text.text = strs;
    }

}
