package com.catherine.linkedlist;

public class SinglyLinkedList<T> {
	private Node<T> head;
    private Node<T> tail;
    int size;
    public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
    }
    
    public void insert(T data, int index) {

        if (index > size) {
            throw new IllegalArgumentException("The index [" + index
                    + "] is greater than the currentent size [" + size + "].");
        } else {

            Node temp = new Node(data);
            Node current = getNode(index);

            if (index == 0) {
                temp.setNextRef(head);
                head = temp;
                tail = head;
            } else {
                temp.setNextRef(current.getNextRef());
                current.setNextRef(temp);
            }

            if ( index == size - 1 ) {
                tail.setNextRef(temp);
                tail = temp;
            }

        }

        size++;
    }
    public void append(T data) {
        insert(data, size);
    }
    private Node getNode(int index) {

        if ( index > size ) {
            throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNextRef();
        }

        return current;
    }
    public void add(T element){
        
        Node<T> nd = new Node<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and 
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
    }
     
    public void addAfter(T element, T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node<T> nd = new Node<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
    
    public void deleteGreatThan(T data){
    	if(head == null) return;
    	if(head.compareTo(data) == 1 && head.getNextRef() == null) return;
    	Node cur = head;

    	while(cur.getNextRef() != null) {
    	    if(cur.getNextRef().compareTo(data) == 1) {
    	        cur.setNextRef(cur.getNextRef().getNextRef());
    	    } else {
    	        cur = cur.getNextRef();
    	    }
    	}
    }
    
    public void delete(T data){
        Node n = this.head;
        if (n==null){
            return;
        }
        if (n.compareTo(data)==0){//If the head is the data we want
            if (n.getNextRef()==null){//If it's the only node, null the head and tail
                this.tail = null;
                this.head = null;
                this.size = 0;
            }
            else {//Or move the head to the next node
                this.head = n.getNextRef();
                this.size--;
            }
            return;
        }
        
        
        while (n.getNextRef()!=null && n.getNextRef().compareTo(data) == 1){//Get the data node or the last node at n.next
            n=n.getNextRef();
        }
        if (n.getNextRef() == null){//If n is the last element in the list
            if (n.compareTo(data) == 1){//If data wasn't in array then we're done
                return;
            }
            //If we're deleting the only remaining element
            if (this.size <=1){
                this.tail = null;
                this.head = null;
                this.size=0;
            }
            else {//If we're just moving the tail
                n.setNextRef(null);
                this.tail = n;
                this.size--;
            }
        }
        else {//If n is not the last element
            if (n.getNextRef().getNextRef()==null){//If n.next is the last element
                n.setNextRef(null);
                this.tail = n;
                this.size--;
            }
            else {//If n.next is not the last element
                n.setNextRef(n.getNextRef().getNextRef());
                this.size--;
            }
        }
    }
    
    public String toString() {
        String list = "";
        list += "[" + this.head.getValue() + "]";

        Node curr = head.getNextRef();
        while (curr != null){
            list += "[" + curr.getValue() + "]";
            curr = curr.getNextRef();
        }

        return list;

    }

    
    public static void main(String a[]){
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.append(3);
        sl.append(32);
        sl.append(54);
        sl.append(89);
        
        System.out.println(sl);
        //sl.addAfter(76, 54);
        //sl.deleteFront();
        //sl.delete(54);
        sl.deleteGreatThan(32);
        System.out.println(sl);
        //sl.traverse();
         
    }
}
