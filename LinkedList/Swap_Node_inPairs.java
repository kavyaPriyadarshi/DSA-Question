/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Input: head = [1,2,3,4]
Output: [2,1,4,3]
  */

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ptr = null;
        ListNode swap = null;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while (temp1 != null && temp2 != null) {
            if (ptr == null) {
                temp1.next = temp2.next;
                temp2.next = temp1;
                ptr = temp1;
                head = temp2;
                System.out.println(temp1.val + " " + temp2.val);
            } else {
                temp1.next = temp2.next;
                temp2.next = temp1;
                ptr.next = temp2;
                ptr = temp1;

            }
            swap = temp1;
            temp1 = temp2;
            temp2 = swap;
            System.out.println(temp1.val + " " + temp2.val);
            if (temp2.next == null) {
                break;
            }
            temp1 = temp2.next;
            temp2 = temp1.next;
            if (temp1 != null && temp2 != null) {
                System.out.println(temp1.val + " " + temp2.val);
            }

        }
        return head;
    }
}
