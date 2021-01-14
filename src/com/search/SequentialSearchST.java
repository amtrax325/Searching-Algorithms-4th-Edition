package com.search;

import java.util.LinkedList;
import java.util.List;

public class SequentialSearchST<Key, Value>
{

    private int size = 0;
    private Node first;
    private class Node
    {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
        return x.val;
        return null;
    }

    public void delete (Key key)
    {
    if(key.equals(first.key))
    {
        first  = first.next;
        size--;
        return;
    }
    Node previous = first;
    for(Node x = first.next; x != null; x = x.next)
    {
        if (key.equals(x.key))
        {
            previous.next = x.next;
            size--;
            return;
        }
        previous = x;
    }


    }
    public int size()
    {
        return size;
    }
    public Iterable<Key> keys()
    {
        List<Key> q = new LinkedList<>();
        for (Node x = first; x!= null; x = x.next)
        {
            q.add(x.key);
        }
        return q;
    }


    public void put(Key key, Value val)
    {
        for (Node x = first; x != null; x = x.next)
            if (key.equals ( x.key))
        { x.val = val; return; }


        first = new Node(key, val, first);
            size++;
    }
}