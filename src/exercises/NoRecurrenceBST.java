package exercises;

import java.util.LinkedList;
import java.util.List;

public class NoRecurrenceBST<Key extends Comparable<Key>,Value>{

    private Node root;

    private class Node{
        private final Key key;
        private Value val;
        private Node left,right;
        private int N;


    public Node (Key key, Value val, int N){
        this.key = key; this.val = val; this.N = N;
        }
    }

    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.N;
    }


    public Value get(Key key)
    {
        Node x = root;
        while (x != null){

            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.val;
            else if (cmp > 0) x = x.right;
            else x = x.left;
        }
        return null;
    }

    public void put(Key key, Value val)
    {
        Node n = new Node(key,val,1);
        if (root == null) {
            root = n;
            return;
        }
        Node x = root;
        Node parent = null;

        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {x.val = val; return;}
            else if (cmp > 0) { parent = x; x = x.right;}
            else  {parent = x; x = x.left;}
        }
        if (key.compareTo(parent.key) > 0)
            parent.right = n;
        else
            parent.left = n;

        x = root;
        while (x.key != key)
        {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return;
            else if (cmp > 0) {x.N++; x = x.right;}
            else {x.N++; x = x.left;}
        }
    }

    public Key min()
    {
        Node x = root;
        while(x.left != null)
        {
             x = x.left;
        }
        return x.key;
    }
    public Key max()
    {
        Node x = root;
        while(x.right != null)
        {
            x = x.right;
        }
        return x.key;
    }


    public Key floor(Key key)
    {
        Node x = root;
        Key t = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            else if (cmp < 0) {
                x = x.left;
            } else {
                t = x.key;
                x = x.right;
            }
        }
        return t;
    }

    public Key ceiling(Key key)
    {
        Node x = root;
        Key t = null;
        while (x!=null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return key;
            else if (cmp > 0) x = x.right;
            else{
                t  = x.key;
                x = x.left;
            }
        }
        return t;


    }



    public Key select(int k)
    {
        Node x  = root;
        while (x != null)
        {
            int t = size(x.left);
            if (t > k)
                x = x.left;
            else if (t < k)
            {
                k = k - t - 1;
                x = x.right;
            }
            else return x.key;
        }
       return null;

    }

    public int rank(Key key)
    {
        Node x = root;
        int total = 0;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp == 0)
                return total + size(x.left);
            else if (cmp < 0)
                x = x.left;
            else {
                total += 1 + size(x.left);
                x = x.right;
            }
        }
        return total;

    }
public void deleteMin()
{
    root = deleteMin(root);
}

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
public void deleteMax()
{
    root = deleteMax(root);
}

private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) +1;
        return x;

    }
    public void delete (Key key)
    {
        root = delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return  null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left,key);
        else if (cmp > 0) x.right = delete(x.right,key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null ) return x.right;
            Node t = x;

            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Iterable<Key> keys()
    {
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> queue = new LinkedList<>();
        keys(root,queue,lo,hi);
        return  queue;

    }

    private void keys(Node x, List<Key> queue, Key lo, Key hi) {
            if (x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0) keys(x.left,queue,lo,hi);
            if (cmplo <= 0 && cmphi >=0 ) queue.add(x.key);
            if (cmphi > 0) keys(x.right,queue,lo,hi);
    }

    public int height()
    {
        return  height(root);

    }

    private int height(Node x) {
        // jezeli drzewo nie ma dzieci, to jego wysokosc wynosi 0
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
public boolean contains(Key key)
{
return this.get(key) != null;
}

}
