package com.search;

import java.util.LinkedList;
import java.util.List;



public class SequentialSearchOrdered<Key extends Comparable<Key>, Value>
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
@Deprecated
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
    public void deleteST(Key key)
    {
        first = delete(first,key);
    }
    private  Node delete(Node x, Key key)
    {
        if(x.key.compareTo(key) == 0)
        {
            size--;
            return x.next;
        }

        x.next = delete(x.next,key);
        return x;
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
          this.insert(key,val);
            size++;
    }


    public int rank(Key key)
    {
        int i = 0;
        for (Node x = first; x!= null; x = x.next)
        {
            int cmp = key.compareTo(x.key);
            if(cmp > 0) i++;
            else  return i;
        }
        return i;
    }
    public Key ceiling (Key key)
    {
        for (Node x = first; x!= null; x = x.next)
        {
           int cmp = key.compareTo(x.key);
            if (cmp == 0) return key;
            else if(cmp < 0) return x.key;

        }
       return null;
    }
    public Key floor(Key key)
    {
        Key k = null;
        for (Node x = first; x!= null; x = x.next)
        {
            int cmp = key.compareTo(x.key);
            if(cmp > 0) k  = x.key;
            else if (cmp == 0)
                return key;
        }
        return k;
    }

    private void insert(Key key, Value val)
    {

        if(size == 0)
        {
            first = new Node(key,val,first);
            return;
        }
        Node x;
        for (x = first; x != null; x = x.next)
        {
            int cmp = x.key.compareTo(key);
            if (cmp < 0 && x.next == null){
                x.next =  new Node(key,val,null);
            return;}
           else if (cmp > 0)
            {
                    Node temp = new Node(x.key,x.val,x.next);
                    x.key = key; x.val = val; x.next =  new Node(temp.key,temp.val,temp.next);
                return;
            }
           else if (cmp == 0)
            {
                x.val = val; return;
            }

        }


    }

}