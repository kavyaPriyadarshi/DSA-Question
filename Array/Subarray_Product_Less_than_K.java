/*
713.
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count =0,window=1;
        int a=0,result_count=0,shift=0;


        if(k<=1){
            return 0;
        }
        for(right = 0;right<nums.length;right++){
            window = window * nums[right];
            
            while(window>=k){
                
                window = window/nums[left];
                left++;
                
                }
                result_count += (right-left +1);
            }

        return result_count;
    }
}
