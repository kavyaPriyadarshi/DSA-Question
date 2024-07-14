/*
3217.
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]

*/
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> st = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }

        ListNode temp1 = head;
        ListNode temp2 = null;

        while(temp1!=null){
            if(st.contains(temp1.val)){
                if(temp1==head){
                    head = head.next;
                }
                else{
                    temp2.next= temp1.next;
                }
            }
            else{
            temp2 = temp1;
            }
            temp1 =temp1.next;
        }
        return head;
    }
}
