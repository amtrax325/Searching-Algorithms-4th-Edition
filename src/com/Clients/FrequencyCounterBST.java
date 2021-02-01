package com.Clients;

import com.search.BST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounterBST {
    public static void main(String[] args) throws FileNotFoundException {
        BST<String, Integer> BinarySearchTree = new BST<>();

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
                if (w.isEmpty())
                    continue;
                if(w.length() < minlen) continue;
                if(!BinarySearchTree.contains(w)) BinarySearchTree.put(w,1);
                else BinarySearchTree.put(w,BinarySearchTree.get(w)+1);
            }
        }
        String max = "";

        BinarySearchTree.put(max,0);
        for (String word : BinarySearchTree.keys())
            if (BinarySearchTree.get(word) > BinarySearchTree.get(max))
                max = word;


        System.out.println(BinarySearchTree.size());
        System.out.println(max + " " + BinarySearchTree.get(max));


    }
}
