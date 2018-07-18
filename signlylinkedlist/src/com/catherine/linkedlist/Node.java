package com.catherine.linkedlist;

public class Node<T> implements Comparable<T> {

	private T value;
    private Node<T> nextRef;
    
    public Node() {
    	 this(null, null);
    }
    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node next) {
        this.nextRef = next;
        this.value = data;
    }
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(T arg) {
    	 return ((Comparable<T>) value).compareTo(arg);
//        if(arg == this.value){
//            return 0;
//        } else {
//            return 1;
//        }
    }
}
