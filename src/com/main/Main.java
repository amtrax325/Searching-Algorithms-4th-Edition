package com.main;

import com.search.BST;
import com.search.BinarySearchST;
import com.search.SequentialSearchST;
import exercises.NoSizeBST;
import exercises.SelfOrderingSearch;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

          BST<String,Integer> a = new BST<>();

a.put("E",1);
a.put("C",1);
a.put("A",1);
a.put("B",1);
a.put("D",1);
a.put("X",1);
a.put("O",1);
a.put("M",1);
a.put("S",1);
//a.put("Z",1);
a.put("Y",1);


        System.out.println(a.keys());



    }
}
