package com.main;

import com.search.BST;
import com.search.BinarySearchST;
import com.search.RedBlackBST;
import com.search.SequentialSearchST;
import exercises.NoSizeBST;
import exercises.PerfectBalancedBST;
import exercises.SelfOrderingSearch;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        RedBlackBST<String,Integer> x = new RedBlackBST<>();


                x.put("g",1);
               x.get("g");
                x.put("a",2);
                x.put("f",2);
                x.put("g",2);
                x.put("u",2);
                x.put("u",56);
                x.put("x",56);
                x.put("i",56);
                x.put("po",56);


                x.get("u");
        System.out.println(x.get("u"));
        System.out.println(x.keys());



    }
}
