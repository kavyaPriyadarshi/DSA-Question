/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l1;
        ListNode ptr = null;
        ListNode head3 = null;
        int carry = 0;
        while (temp1 != null) {
            temp2 = temp1.next;
            temp1.next = ptr;
            ptr = temp1;
            temp1 = temp2;
        }
        l1 = ptr;
        temp1 = l2;
        temp2 = l2;
        ptr = null;
        while (temp2 != null) {
            temp2 = temp1.next;
            temp1.next = ptr;
            ptr = temp1;
            temp1 = temp2;
        }
        /*
         * while(ptr!=null){
         * System.out.println(ptr.val);
         * ptr = ptr.next;
         * }
         */
        l2 = ptr;
        temp1 = l1;
        temp2 = l2;
        ptr = null;
        while (temp1 != null && temp2 != null) {
            if (ptr == null) {
                ListNode lt = new ListNode();
                lt.val = (temp1.val + temp2.val) % 10;
                head3 = lt;
                ptr = head3;
            } else {
                ListNode lt = new ListNode();
                lt.val = (temp1.val + temp2.val + carry) % 10;
                ptr.next = lt;
                ptr = ptr.next;
            }
            carry = (temp1.val + temp2.val + carry) / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 == null && temp2 == null) {
            ListNode lt = new ListNode();
            if (carry != 0) {
                lt.val = 1;
                ptr.next = lt;
            }
        } else if (temp1 != null) {
            while (temp1 != null) {
                ListNode lt = new ListNode();
                lt.val = (carry + temp1.val) % 10;
                ptr.next = lt;
                ptr = ptr.next;
                carry = (carry + temp1.val) / 10;
                temp1 = temp1.next;
            }
        } else {
            while (temp2 != null) {
                ListNode lt = new ListNode();
                lt.val = (carry + temp2.val) % 10;
                ptr.next = lt;
                ptr = ptr.next;
                carry = (carry + temp2.val) / 10;
                temp2 = temp2.next;
            }
        }

        if (carry != 0) {
            ListNode lt = new ListNode();
            lt.val = 1;
            ptr.next = lt;
        }
        temp1 = head3;
        temp2 = head3;
        ptr = null;
        while (temp1 != null) {
            temp2 = temp1.next;
            temp1.next = ptr;
            ptr = temp1;
            temp1 = temp2;
        }
        return ptr;

    }
}
