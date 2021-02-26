package com.search;

import java.util.LinkedList;
import java.util.List;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean  RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private Node latest;
    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.color = color;
            this.val = val;
            this.N = N;
        }
    }
    private  boolean isRed(Node x)
    {
        if (x == null)
            return false;
        return x.color == RED;
    }
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private Node rotateRight(Node h)
    {
        Node x= h.left;
        h.left = x.right;
        x.right = h;
        x. color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private  void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        if( latest != null &&  key == latest.key)
            return latest.val;
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        if(latest != null && key == latest.key)
            latest.val = val;
        root = put(root, key, val); root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1,RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;

        latest = h;
        return h;

    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return (min(x.left));
    }


    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return (max(x.right));

    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }


    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;

    }


    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {

        if (x == null) return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {

        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return size(x.left);
        else if (cmp < 0)
            return rank(key, x.left);
        else
            return 1 + size(x.left) + rank(key, x.right);
    }
/*
    public void deleteMin() {
        //TODO
    }

    private Node deleteMin(Node x) {
        //TODO
    }

    public void deleteMax() {
        //TODO
    }

    private Node deleteMax(Node x) {
        //TODO;

    }

    public void delete(Key key) {
        //TODO;
    }

    private Node delete(Node x, Key key) {
        //TODO;
    }

 */

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;

    }

    private void keys(Node x, List<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int height() {
        return height(root);

    }

    private int height(Node x) {
        // jezeli drzewo nie ma dzieci, to jego wysokosc wynosi 0
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public boolean contains(Key key) {
        return this.get(key) != null;
    }




}