package com.bridgelabz;

public class MyLinkedList<K> {
    /**
     * Initializing head and tail variables of type INode
     */
    private INode<K> head;
    private INode<K> tail;

    /**
     * Traverse through the node and prints the data
     */
    public void display() {
        MyHashTableNode node = (MyHashTableNode) this.head;
        //System.out.println("Frequency of words: ");
        while (node != null) {
            System.out.print(node.getKey()+":"+node.getValue()+", ");
            node = node.getNext();
        }
    }

    /**
     * Logic for adding nodes to linked list
     * @param newNode - add this new node to the existing node
     */
    public void add(INode newNode) {
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            INode temp = this.head;
            this.head = newNode;
            this.head.setNext(temp);
        }
    }

    /**
     * Logic for appending the nodes to linked list
     * @param newNode - append this to the existing node
     */
    public void append(INode newNode){
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    /**
     * Creating search method to search the desired element
     * @param data - which date you want to search
     * @return address of node
     */
    public INode searchData(K data) {
        if(this.head == null){
            return null;
        }

        INode tempNode = this.head;
        while(tempNode != null) {
            if (tempNode.getKey().equals(data)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    /**
     * Creating the size method to know the size of linked list
     * @return - The size of the linked list
     */
    public int size() {
        int size = 0;
        if (this.head == null) {
            return size;
        }
        size++;
        INode temp = this.head;
        while (temp.getNext() != null) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    /**
     *
     * @return the key value pair as word and frequency
     */
    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}




