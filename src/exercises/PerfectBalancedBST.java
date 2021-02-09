package exercises;

import com.search.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PerfectBalancedBST {

    private BST<Integer,Integer> a = new BST<>();
    private ArrayList<Integer> keys = new ArrayList<>(20);

    public PerfectBalancedBST(int size)
    {
        int l = 1;
        for (int i = 0; i < size; i++)
            keys.add(l++);

        addToBst(0,size-1);
    }
    private void addToBst(int lo,int hi)
    {

        if (lo > hi)
            return;
        int mid = lo + (hi - lo) / 2;
        a.put(  keys.get(mid),1);
            addToBst(lo,mid-1);
            addToBst(mid+1,hi);

    }
}
