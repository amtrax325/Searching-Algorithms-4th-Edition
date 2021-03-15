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


           x.put("E",1);
           x.put("S",1);
           x.put("U",1);
           x.put("T",1);
           x.put("Y",1);
           x.put("A",1);
           x.put("Q",1);

           x.delete("E");


    }
}
