package com.example.springbootdemo.demos.util;

public class LinkedListTest {

    class Node{
        int data;//节点数据
        Node next;//指向下一个节点的指针
        public Node(int data) {
            this.data = data;
        }
    }

    public Node createNode(){
        Node head = new Node(11);
        Node second = new Node(21);
        Node third = new Node(31);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        return head;
    }

    public Node reverseLinkedList(Node head){
            Node prev = null;
            Node current = head;
            while(current!= null){
                Node tempNext = current.next;
                current.next = prev;
                prev = current;
                current = tempNext;
            }
            return prev;
    }

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        Node head = linkedListTest.createNode();
        Node reversedHead = linkedListTest.reverseLinkedList(head);
        while(reversedHead != null){
            System.out.print(reversedHead.data + " ");
            reversedHead = reversedHead.next;
        }
    }

}
