package com.Clients;

import com.binarySearch.BinarySearchST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
//TODO: better implementation of function which gets words frome .txt file
        BinarySearchST<String,Integer> binarySearch = new BinarySearchST<>(1);
        File file = new File("tale.txt");
        Scanner in = new Scanner(file);

        while(in.hasNext())
        {
            String word = in.next();
            if(word.length() < 0)  continue;
            if(!binarySearch.contains(word)) binarySearch.put(word,1);
            else binarySearch.put(word,binarySearch.get(word)+1);
        }
        String max = "";
        binarySearch.put(max,0);
        for (String word : binarySearch.keys())
            if (binarySearch.get(word) > binarySearch.get(max))
                max = word;

        System.out.println(binarySearch.size());
        System.out.println(max + " " + binarySearch.get(max));

    }



    }
