/*
2487.
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
*/

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();
        ListNode temp = head;
        ListNode ptr = null;
        int max = 0;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!st.isEmpty()) {
            int num = st.pop();
            if (max <= num) {
                temp = new ListNode();
                if (ptr != null) {
                    temp.next = ptr;
                }
                temp.val = num;
                ptr = temp;
                max = num;
            }

        }
        return ptr;
    }
}
