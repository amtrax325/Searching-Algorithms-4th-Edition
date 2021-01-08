package com.Clients;

import com.binarySearch.BinarySearchST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {

        BinarySearchST<String,Integer> binarySearch = new BinarySearchST<>();
        File file = new File("tale.txt");
        Scanner in = new Scanner(file);

        //while(in.hasNext())
        for(int i = 0; i < 500; i++)
        {
            String word = in.next();
            if(word.length() < 10)  continue;
            if(!binarySearch.contains(word)) binarySearch.put(word,1);
            else binarySearch.put(word,binarySearch.get(word)+1);
        }
        String max = "";
        binarySearch.put(max,0);
        for (String word : binarySearch.keys())
            if (binarySearch.get(word) > binarySearch.get(max))
                max = word;

        System.out.println(max + " " + binarySearch.get(max));

    }

}
