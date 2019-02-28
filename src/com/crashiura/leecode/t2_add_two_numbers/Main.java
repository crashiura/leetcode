package com.crashiura.leecode.t2_add_two_numbers;

public class Main {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        int remainder = 0;
        int carry = 0;
        int res = 0;
        ListNode currentNode = result;

        while (l1 != null || l2 != null || carry != 0) {
            res = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            remainder = res % 10;
            carry = res / 10;
            ListNode node = new ListNode(remainder);
            currentNode.next = node;
            currentNode = node;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        return result.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
