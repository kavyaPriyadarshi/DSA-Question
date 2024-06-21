/*
Given a 0-indexed integer array nums, determine whether there exist two subarrays of length 2 with equal sum. Note that the two subarrays must begin at different indices.
Return true if these subarrays exist, and false otherwise.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [4,2,4]
Output: true
Explanation: The
*/

class Solution {
    public boolean findSubarrays(int[] nums) {
        boolean temp = false;
        int sum=0;
        Set<Integer> st = new HashSet<Integer>();
        for(int i=0;i<nums.length-1;i++){
            sum  = nums[i] + nums[i+1];
            if(st.contains(sum)){
                temp =true;
                break; 
            }
            else{
                st.add(sum);
            }
        }
        return temp;
    }
}
