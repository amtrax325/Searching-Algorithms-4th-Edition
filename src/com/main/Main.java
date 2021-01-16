package com.main;

import com.search.BinarySearchST;
import com.search.SequentialSearchST;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        BinarySearchST<String,Integer> a  = new BinarySearchST<>(1);

        a.put("c",2);
        a.put("d",2);

        a.put("a",2);
        a.put("f",2);
        a.put("g",2);

        System.out.println(a.keys());
        System.out.println(a.floor("i"));


    }
}
