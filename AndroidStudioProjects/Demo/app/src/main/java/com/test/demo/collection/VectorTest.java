package com.test.demo.collection;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by Li Zhi
 * 2017/3/15.
 */

public class VectorTest {
    public static void main(String[] args){
        Vector<String> vector = new Vector<>();
        vector.addElement("test");
        Vector<String> second = new Vector<>();
        second.addElement("second");
        vector.addAll(second);
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        ArrayList<String> arrayList;
        LinkedList<String> linkedList;
        HashSet<String> hashSet;
        HashMap<String,String> hashMap;
        TreeMap<String,String> treeMap;
        Hashtable<String,String> hashtable;
        ByteArrayInputStream inputStream;
        ByteArrayOutputStream outputStream;
        PrintWriter writer;
        OutputStreamWriter outputStreamWriter;
        RandomAccessFile randomAccessFile;
        ObjectOutputStream objectOutputStream;
    }
}
