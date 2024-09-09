/*
725.
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

 

Example 1:


Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].

*/


class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode ptr = head;
        ListNode temp = null;
        int count = 0;
        while (ptr != null) {

            ptr = ptr.next;

            count++;
        }

        ListNode[] arr = new ListNode[k];
        ptr = head;

        int z = 0;
        if (count <= k) {
            while (ptr != null) {
                arr[z] = ptr;
                temp = ptr;
                ptr = ptr.next;
                temp.next = null;
                z++;
            }

        } else {
            int[] arr2 = new int[k];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = count / k;
            }
            int m = count % k;

            int a = -1;
            while (m > 0) {
                arr2[(a + 1) % arr2.length] += 1;
                a++;
                m--;
            }
            int b = 0;
            while (b < k) {
                arr[b] = ptr;
                int y = arr2[b];
                while (y > 0 && ptr != null) {
                    temp = ptr;
                    ptr = ptr.next;
                    y--;
                }
                temp.next = null;
                b++;
            }

        }
        return arr;

    }
}
