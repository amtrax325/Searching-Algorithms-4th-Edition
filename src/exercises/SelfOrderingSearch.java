package exercises;

import java.util.LinkedList;
import java.util.List;

// task 3.1.2
public class SelfOrderingSearch<Key, Value> {

    private  Key [] keys;
    private Value [] vals;
    private int N;
    private int arrayCapacity;

    public SelfOrderingSearch(int capacity)
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
                return move(i);

            return null;
    }

    private Value move(int p)
    {
        Key key = keys[p];
        Value value = vals[p];
        while(p > 0)
        {
            keys[p] = keys[p-1];
            vals[p] = vals[p-1];
            p--;
        }
        keys[0] = key;
        vals[0] = value;
        return value;

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
