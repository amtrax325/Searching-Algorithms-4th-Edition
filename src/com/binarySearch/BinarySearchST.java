package com.binarySearch;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class BinarySearchST<Key extends  Comparable<Key>, Value>  {

    private  Key [] keys;
    private Value [] vals;
    private int N;
    private int arrayCapacity;
    public BinarySearchST(int capacity)
    {
        keys = (Key[]) new Comparable [capacity];
        vals = (Value[]) new Comparable [capacity];
        arrayCapacity = capacity;
    }
    public int size()
    {return N;}

    public Value get(Key key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return  null;
    }

  public void put(Key key, Value val)
  {
      int i = rank(key,0,N-1);
      if (i < N && keys[i].compareTo(key) == 0) {vals[i] = val; return;}
      if(N+1  == arrayCapacity)
          changeSize();
      for (int j = N; j > i; j--)
      {
          keys[j] = keys[j-1];
          vals[j] = vals[j-1];
      }
      keys[i] = key; vals[i] = val;
      N++;

  }

public Key min()
{return keys[0]; }
public Key max()
{return keys[N-1];}
public Key select(int k)
{return keys[k];}
public Key ceiling(Key key)
{
    int i = rank(key);
    return keys[i];
}
public Key floor(Key key)
{
    //TODO: implement floor method
    return null;
}

  public void delete(Key key){
        //TODO: implement delete method
  }
  //recursion version of rank
  private int rank(Key key, int l, int h)
   {
       int lo = l, hi = h;
       if (lo > hi)
           return lo;
       int mid = lo + (hi - lo) / 2;
       int cmp = key.compareTo(keys[mid]);
       if (cmp < 0) return rank(key,lo,mid-1);
       else  if (cmp > 0) return rank(key,mid+1,hi);
       else return mid;
   }



    private int rank(Key key) {
        int lo = 0, hi = N-1;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid  - 1;
            else if (cmp > 0) lo = mid  + 1;
            else return mid;
        }
        return lo;
    }

public Iterable<Key> keys(Key lo, Key hi)
{
    List<Key> q = new LinkedList<>();
    for (int i = rank(lo); i < rank(hi); i++)
        q.add(keys[i]);
        if (contains(hi))
             q.add(keys[rank(hi)]);
    return q;
}
public Iterable<Key> keys()
{
    List<Key> q = new LinkedList<>();
    for (int i = rank(keys[0]); i < rank(keys[N-1]); i++)
        q.add(keys[i]);
    if (contains(keys[N-1]))
        q.add(keys[rank(keys[N-1])]);
    return q;
}


    public boolean contains(Key key)
    {
        if(get(key) == null) return false;
        return true;
    }

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
    private boolean isEmpty() {
        return N == 0;
    }


}
