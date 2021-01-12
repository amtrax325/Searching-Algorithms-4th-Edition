package com.Clients;

import com.search.BinarySearchST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {

        BinarySearchST<String,Integer> binarySearch = new BinarySearchST<>(1);
        File file = new File("tale.txt");
        Scanner in = new Scanner(file);

        int minlen = 8;

        while (in.hasNextLine())
        {
            String word = in.nextLine();

            word = word.replaceAll(",|\\.|\\?|;|\\*|!|-|:|\"","");
            String [] words = word.split("\\s");

            for (String w : words)
            {
                if(w.isEmpty())
                     continue;
                if(w.length() < minlen) continue;
                if(!binarySearch.contains(w)) binarySearch.put(w,1);
                 else binarySearch.put(w,binarySearch.get(w)+1);
            }
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
