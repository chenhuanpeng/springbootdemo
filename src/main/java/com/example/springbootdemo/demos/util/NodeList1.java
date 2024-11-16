package com.example.springbootdemo.demos.util;

public class NodeList1 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 基础情况：空链表或只有一个节点的链表
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后续链表
        ListNode newHead = reverseList(head.next);

        // 反转当前节点的指针
        head.next.next = head;
        head.next = null; // 将当前节点的 next 设置为 null

        return newHead; // 返回新的头节点
    }


}
