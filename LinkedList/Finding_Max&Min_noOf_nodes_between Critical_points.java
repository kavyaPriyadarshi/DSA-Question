/*

A critical point in a linked list is defined as either a local maxima or a local minima.
A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

Example 1:

Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].
*/
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        ListNode temp2 = head;
        int count = 0;
        int[] arr = new int[2];

        Stack<Integer> st = new Stack<Integer>();

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head.next;
        temp2 = head;
        count = 2;
        while (temp.next != null) {
            if ((temp.val < temp2.val && temp.val < temp.next.val)
                    || (temp.val > temp2.val && temp.val > temp.next.val)) {
                st.push(count);
            }
            temp2 = temp;
            temp = temp.next;

            count++;
        }
        if (st.size() < 2) {
            arr[0] = arr[1] = -1;
        } else if (st.size() == 2) {
            arr[0] = arr[1] = (st.pop() - st.pop());
        } else {
            if (st.size() > 2) {
                int min = 1000000;
                for (int i = 0; i < st.size() - 1; i++) {
                    int val = st.get(i + 1) - st.get(i);
                    min = Math.min(min, val);
                }
                arr[0] = min;
                arr[1] = st.peek() - st.get(0);
            }
        }
        return arr;
    }
}
