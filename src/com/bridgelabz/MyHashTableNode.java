package com.bridgelabz;

/**
 * Creating MyHashTableNode consisting of key,value,next
 * @param <K> - key
 * @param <V> - value
 */

public class MyHashTableNode<K, V> implements INode<K>{

    private K key;
    private V value;
    private MyHashTableNode<K, V> next;

    /**
     * Parameterized constructor having key and value as parameters
     * @param key - to hold key
     * @param value - to hold value
     */
    public MyHashTableNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Overriding  getter and setter methods of Interface
     */

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void setNext(INode<K> next) {
        this.next = (MyHashTableNode<K, V>) next;
    }

    @Override
    public MyHashTableNode<K, V> getNext() {
        return next;
    }
}
