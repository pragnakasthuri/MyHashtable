package com.bridgelabz;

/**
 * Ability to find frequency of words in a sentence like “To be or not to be”
 * @param <K> - key
 * @param <V> - value
 */

public class MyHashtable<K, V> {
    private MyLinkedList<K> myLinkedList;

    /**
     * Default Constructor of MyHashTable, which is assigning a new MyLinkedList object
     */
    MyHashtable() {
        this.myLinkedList = new MyLinkedList<>();
    }

    /**
     * getValue method returns the value for the given key
     * @param key - Takes the key as input
     * @return - The value for the key given
     */
    public V getValue(K key) {
        MyHashTableNode<K, V> myHashTableNode = (MyHashTableNode<K, V>) this.myLinkedList.searchData(key);
        if (myHashTableNode == null) {
            return null;
        } else {
            return myHashTableNode.getValue();
        }
    }

    /**
     * @param key - key of HashTable
     * @param value - value of Hashtable
     */
    public void add(K key, V value) {
        MyHashTableNode<K, V> myHashTableNode = (MyHashTableNode<K, V>) this.myLinkedList.searchData(key);
        if (myHashTableNode == null) {
            myHashTableNode = new MyHashTableNode<>(key, value);
            this.myLinkedList.append(myHashTableNode);
        } else {
            myHashTableNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "MyHashtable{" +
                "myLinkedList=" + myLinkedList +
                '}';
    }

    /**
     * Main method for manipulating HashTable
     * @param args - Default java Param
     */
    public static void main(String[] args) {
        /**
         * PROCEDURE:
         * 1.The given string is taken and splitting it when space occurs
         * 2.Creating MyHashTable
         * 3.Finding the frequency of word using getValue and Search methods
         * and adding the word and frequency to MyHashTable ad key and value
         * 4.Calling the display method of MyLinkedList to display the word and frequency
         * 5.Calling the size method of my linked list and displaying the size
         */

        /**
         * 1.The given string is taken and splitting it when space occurs
         */
        String givenString = "To be or not to be";
        String[] wordsInGivenString = givenString.toLowerCase().split(" ");
        /**
         * 2.Creating MyHashTable
         */
        MyHashtable<String, Integer> myHashtable = new MyHashtable<>();
        /**
         * 3.Finding the frequency of word using getValue and Search methods
         * and adding the word and frequency to MyHashTable ad key and value
         */
        for(String word : wordsInGivenString) {
            Integer frequency = myHashtable.getValue(word);
            frequency = frequency == null ? 1 : frequency + 1;
            myHashtable.add(word, frequency);
        }

        /**
         * 4.Calling the display method of MyLinkedList to display the word and frequency
         */
        myHashtable.myLinkedList.display();
        System.out.println();
        /**
         * 5.Calling the size method of my linked list and displaying the size
         */
        System.out.println("Size: " +myHashtable.myLinkedList.size());
    }
}
