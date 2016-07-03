package com.ashok.learning;

/**
 * The {@code SinglyLinkedList} class is a template to learn SinglyLinkedList.
 * Next node for tail should be null always.
 *
 * @author Ashok Rajpurohit (ashok1113@gmail.com).
 */
public class SinglyLinkedList {
    private Node head, tail; // first and last element.
    private int size = 0; // number of elements in list.

    SinglyLinkedList() {
    }

    public void add(int value) {
        /**
         * Write code here. If head and tail node are null (not initialized first time)
         * then this value in head/tail node.
         * For single node, head and tail are same.
         * Afterwards create new Node and add it to next to tail and
         * move tail to next (newly created node)
         * increment size also.
         */
        if(head == null){
            head = new Node(value);
            tail=head;
            size=1;
        }
        else{
            Node newNode = new Node(value,head);
            tail = newNode;
            size++;
        }
    }

    public boolean contains(int value) {
        /**
         * Search the list for this value and if found return true.
         * Use temp node to iterate over the list.
         * Do not change head node as head = head.next
         */
        Node temp = head;
        int flag = 0;
        if(size > 0){
            do{
                if(temp.value == value){
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }while(temp != null);
        }

        return (flag == 1) ? true : false;
//        return flag;
    }

    public boolean delete(int value) {
        /**
         * Iterate through the list using temp node as in contains method.
         * let's say n2 is the node to be deleted and n1.next is n2,
         * so we have to delete from previous node.
         * just update the reference for n1.next from n2 to n2.next
         */
        Node temp = head;
        Node previous = head;
        int flag = 0;
        if(contains(value)){
            if(size == 1){
                flag = 1;
                head=null;
                tail=null;
                size--;
            }
            else{
                do{
                    if(temp.value==value && temp==head){
                        flag=1;
                        head=head.next;
                        size--;
                        break;
                    }
                    if(temp.value == value){
                        flag=1;
                        previous.next=temp.next;
                        size--;
                        break;
                    }
                    if(temp.value==value && temp==tail){
                        flag=1;
                        previous.next=null;
                        size--;
                        tail=previous;
                        break;
                    }
                    previous=temp;
                    temp=temp.next;
                }while(temp!=null);
            }
        }

        return (flag == 1) ? true : false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        /**
         * If the list has 0 elements return true, else false
         */

        return size == 0;
    }

    final static class Node {
        int value;
        Node next;

        Node(int v) {
            // write code here
            this.value = v;
            this.next=null;
        }

        Node(int v, Node n) {
            // write code here to initialize value and next Node.
            Node newNode = new Node(v);
            n.next=newNode;
            
        }
    }
}
