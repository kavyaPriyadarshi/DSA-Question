/*
92.
Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode ptr = null;
        ListNode temp3 = null;
        ListNode temp4 = null;

        if (left == right) {
            return head;
        }
        ListNode temp_left = head;
        ListNode temp_right = head;
        while (count < left - 2) {
            temp_left = temp_left.next;
            count++;
        }
        count = 0;
        while (count < right - 1) {
            temp_right = temp_right.next;
            count++;
        }
        temp1 = temp_left;
        if (left != 1) {
            temp3 = temp_left.next;
        } else {
            temp3 = temp_left;
        }
        temp2 = temp_right.next;
        count = 0;
        while (count < ((right - left) + 1)) {
            temp4 = temp3.next;
            temp3.next = ptr;
            ptr = temp3;
            temp3 = temp4;
            count++;

        }
        if (left != 1) {
            temp1.next = ptr;
        } else {
            head = ptr;
        }
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        if (temp2 != null) {
            ptr.next = temp2;
        }

        return head;

    }
}
