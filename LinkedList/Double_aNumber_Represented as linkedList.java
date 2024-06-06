/*

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.

Example 1:

Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
*/

class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = 0;
        Stack<Integer> st = new Stack<Integer>();
        ListNode ptr = head;

        //Storing value of node from right side into stack
        while (ptr != null) {
            st.push(ptr.val);
            ptr = ptr.next;
        }
        ptr = null;
        while (!st.isEmpty()) {
            int value = st.pop();
            value = value * 2;
            value += carry;
            ListNode lt = new ListNode();
            lt.next = ptr;
            lt.val = value % 10;
            ptr = lt;
            carry = value / 10;
        }
        if (carry != 0) {
            ListNode lt = new ListNode();
            lt.val = 1;
            lt.next = ptr;
            ptr = lt;
        }
        return ptr;
    }
}
