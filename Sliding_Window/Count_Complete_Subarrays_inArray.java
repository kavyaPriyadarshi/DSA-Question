/*
2799.
You are given an array nums consisting of positive integers.
We call a subarray of an array complete if the following condition is satisfied:
The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.
A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
*/
//This is a sliding window question but not done using sliding window
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> st = new HashSet<Integer>();
        HashSet<Integer> st2 = new HashSet<Integer>();

        int distinct_count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!st.contains(nums[i])) {
                st.add(nums[i]);
                distinct_count++;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (!st2.contains(nums[j])) {
                    st2.add(nums[j]);
                }
                if (st.size() == st2.size()) {
                    count++;
                }

            }
            st2.clear();
        }
        return count;
    }
}
