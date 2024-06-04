/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.
Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp1 = head;
        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        if (count <= 2) {
            return head;
        } else {
            ListNode temp2 = head.next;
            ListNode head1 = head.next;

            while (temp1 != null && temp2 != null) {
                if (temp2.next == null) {
                    break;
                }
                temp1.next = temp2.next;
                temp1 = temp1.next;
                temp2.next = temp1.next;
                temp2 = temp2.next;

            }

            temp1.next = head1;
        }
        return head;
    }
}
