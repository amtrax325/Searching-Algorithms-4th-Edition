package com.main;

import com.search.SequentialSearchOrdered;
import com.search.SequentialSearchST;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        SequentialSearchOrdered<String,Integer> a = new SequentialSearchOrdered<>();


        a.put("1",1);
        a.put("2",1);
        a.put("3",1);
        a.put("4",1);
        a.put("5",1);
        a.put("6",1);
        a.put("7",1);

        System.out.println(a.keys());
        a.deleteST("4");
        System.out.println(a.keys());
    }
}
