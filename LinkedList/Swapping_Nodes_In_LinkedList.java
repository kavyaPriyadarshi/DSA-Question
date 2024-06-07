/*

You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode temp1 = head;
        int size = 0;

        while (temp1 != null) {
            size++;
            temp1 = temp1.next;
        }
        temp1 = head;
        while (count < (k - 1)) {
            temp1 = temp1.next;
            count++;
        }
        count = 0;
        ListNode temp2 = head;
        while (count < (size - k)) {
            temp2 = temp2.next;
            count++;
        }

        int num = 0;
        num = temp1.val;
        temp1.val = temp2.val;
        temp2.val = num;
        return head;

    }
}
