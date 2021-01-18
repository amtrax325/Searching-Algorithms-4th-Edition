package com.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// task 3.1.2
public class ArrayST <Key, Value> {

    private  Key [] keys;
    private Value [] vals;
    private int N;
    private int arrayCapacity;

    public ArrayST(int capacity)
    {
        keys = (Key[]) new Comparable [capacity];
        vals = (Value[]) new Comparable [capacity];
        arrayCapacity = capacity;
    }
    public void put(Key key, Value val)
    {
        for (int i =0; i  < N; i++)
            if(key.equals(keys[i]))
            {
                vals[i] = val; return;
            }

        keys[N] = key; vals[N]= val;
        N++;
        if (N+1  >= arrayCapacity)
             changeSize();

    }
    public Value get(Key key)
    {
        for (int i =0; i  < N; i++)
            if(key.equals(keys[i]))
                return vals[i];

            return null;
    }

    public Value delete(Key key)
    {
        for (int i =0; i  < N; i++)
            if(key.equals(keys[i]))
            {
                Value v=  vals[i];
                keys[i] = keys[N-1];
                vals[i] = vals[N-1];

                keys[N-1]   = null;
                vals[N-1] = null;
                N--;
                return v;
            }
        return null;
    }
    public boolean contains(Key key)
    {
        for (int i =0; i  < N; i++)
            if(key.equals(keys[i]))
                return true;

        return false;
    }
    public boolean isEmpty()
    {return N == 0; }
    public int size()
    {return N;}
    private void changeSize()
    {
        Key [] tempKey = keys;
        Value [] tempValue = vals;

        keys = (Key[]) new Comparable [arrayCapacity*2];
        vals = (Value[]) new Comparable [arrayCapacity*2];

        for (int i = 0; i < arrayCapacity; i++)
        {
            keys[i] = tempKey[i];
            vals[i] = tempValue[i];
        }
        arrayCapacity*=2;
    }
    public Iterable<Key> keys()
    {

        List<Key> q = new LinkedList<>();
        for (int i = 0; i < N; i++)
            q.add(keys[i]);

        return q;
    }
}
