package com.bridgelabz;
/**
 * Ability to find frequency of words in a large phrase
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Creating a generic MyLinkedHashtable with key and value
 * @param <K> - key
 * @param <V> - value
 */
public class MyLinkedHashtable<K, V> {
    private final int bucketSize = 10;
    private List<MyLinkedList> bucketList = null;

    /**
     * Non-parameterized constructor of MyLinkedHashtable
     */
    MyLinkedHashtable() {
        this.bucketList = new ArrayList<>(this.bucketSize);

        for(int i=0; i<bucketSize; i++) {
            this.bucketList.add(null);
        }
    }

    /**
     * This method is used to calculate the index of the key by performing
     * modulo operation between hashcode and bucket size
     * @param key - takes the key as input
     * @return the index of the key
     */
    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % bucketSize;
        return index;
    }

    /**
     * getValue method returns the value for the given key
     * @param key - Takes the key as input
     * @return - The value for the key given
     */
    public V getValue(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList myLinkedList = this.bucketList.get(index);
        if (myLinkedList == null) {
            return null;
        }
        MyHashTableNode<K, V> myHashTableNode = (MyHashTableNode<K, V>) myLinkedList.searchData(key);
        if (myHashTableNode == null) {
            return null;
        } else {
            return myHashTableNode.getValue();
        }
    }

    /**
     * Adds the key value pair to linked list
     * @param key - key of HashTable
     * @param value - value of Hashtable
     */
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList myLinkedList = this.bucketList.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList();
            this.bucketList.set(index, myLinkedList);
        }
        MyHashTableNode<K, V> myHashTableNode = (MyHashTableNode<K, V>) myLinkedList.searchData(key);
        if (myHashTableNode == null) {
            myHashTableNode = new MyHashTableNode<>(key, value);
            myLinkedList.append(myHashTableNode);
        } else {
            myHashTableNode.setValue(value);
        }
    }

    /**
     * Main method for manipulating MyLinkedHashtable
     * @param args - default java param
     */
    public static void main(String[] args) {
        /**
         * 1.Assigning the given string to sentence
         */
        String sentence = "Paranoids are not " +
                "paranoid because they are paranoid but " +
                "because they keep putting themselves " +
                "deliberately into paranoid avoidable " +
                "situations";
        /**
         * 2.Creating the object for MyLinkedHashtable
         */
        MyLinkedHashtable<String, Integer> myLinkedHashtable = new MyLinkedHashtable<>();
        /**
         * 3.Finding the frequency of word using getValue and Search methods
         * and adding the word and frequency to MyHashTable ad key and value
         */
        for(String word : sentence.toLowerCase().split(" ")) {
            Integer frequency = myLinkedHashtable.getValue(word);
            frequency = frequency == null ? 1 : frequency + 1;
            myLinkedHashtable.add(word, frequency);
        }

        /**
         * 4.Traverse through the MyLinkedHashTable
         */
        for(MyLinkedList linkedList : myLinkedHashtable.bucketList) {
            if (linkedList != null) {
                System.out.println("");
                /**
                 * 5.Calling the display method of linked list
                 */
                linkedList.display();
            }
        }
    }
}
