/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        int count = 0;
        ListNode temp = null, temp1 = head;

        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        ptr = null;
        if (count <= 1) {
            return head;
        } else if (count == 2) {
            if (head.val != head.next.val) {
                temp = head;
            }
        } else {
            ListNode temp2 = head.next;
            while (temp1 != null && temp2.next != null) {
                if (temp1.val != temp2.val) {
                    if (temp1.next == temp2) {
                        if (ptr == null) {

                            ptr = temp1;
                            head = ptr;

                        } else {
                            ptr.next = temp1;
                            ptr = temp1;

                        }
                    }
                    temp1 = temp2;

                }

                temp2 = temp2.next;

            }
            if (temp1.val == temp2.val) {
                if (ptr == null) {
                    temp = null;
                } else {

                    ptr.next = null;

                    temp = head;
                }

            } else if (temp1.val != temp2.val) {
                if (temp1.next == temp2) {
                    if (ptr == null) {
                        head = temp1;
                    } else {
                        ptr.next = temp1;
                    }
                } else {
                    if (ptr != null) {
                        ptr.next = temp2;
                    } else {
                        head = temp2;
                    }
                }

                temp = head;

            }
        }
        return temp;
    }
}
