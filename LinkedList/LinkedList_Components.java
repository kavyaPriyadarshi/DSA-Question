/*
You are given the head of a linked list containing unique integer values and an integer array nums that is a subset of the linked list values.
Return the number of connected components in nums where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: head = [0,1,2,3], nums = [0,1,3]
Output: 2
Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
*/

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        Boolean temp1 = false, temp2 = true;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], 1);
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (mp.containsKey(temp.val) && mp.containsKey(temp.next.val)) {
                mp.replace(temp.val, -1);
                mp.replace(temp.next.val, -1);
                temp1 = true;

            } else {
                temp2 = false;
                if (temp1 == true && temp2 == false) {
                    count++;
                }
                temp1 = false;
                temp2 = true;
            }
            temp = temp.next;
        }
        if (temp1 == true && temp2 == true) {
            count++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mp.get(nums[i]) == 1) {
                count++;
            }
        }
        return count;
    }
}
