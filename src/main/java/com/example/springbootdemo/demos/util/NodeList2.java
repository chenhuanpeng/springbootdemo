package com.example.springbootdemo.demos.util;

public class NodeList2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 保存当前节点的下一个节点
            curr.next = prev;               // 反转当前节点的指针
            prev = curr;                    // 移动 prev 指针
            curr = nextTemp;                // 移动到下一个节点
        }

        return prev; // prev 最终会成为新的头节点
    }

    public ListNode createList() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(6);
        return head;
    }

    public static void main(String[] args) {
        NodeList2 list = new NodeList2();
        ListNode head = list.createList();
        ListNode newHead = list.reverseList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }


}
