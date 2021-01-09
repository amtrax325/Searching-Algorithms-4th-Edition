package com.main;

import com.binarySearch.BinarySearchST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

            BinarySearchST<String,Integer> a  = new BinarySearchST<>(1);

            a.put("C",1);
            a.put("X",5);
            a.put("Y",8);
            a.put("A",0);
            a.put("C",6);
            a.put("B",6);
            a.put("D",6);

        Iterable<String> x = new ArrayList<>();


        x = a.keys();

        x.forEach(System.out::println);


    }
}
