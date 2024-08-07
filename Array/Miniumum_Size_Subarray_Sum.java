/*
209.
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left =0;
        int sum=0;
        

        for(int right=0;right<nums.length;right++){
            if(nums[right]>=target){
                return 1;
            }
            sum = sum + nums[right];
            

                while(sum>=target && left<right){
                    min = Math.min(right-left+1,min);
                    sum = sum - nums[left];
                    left++;
                }

        
        }
        if(min==Integer.MAX_VALUE){
        return 0;
        }
        else{
            return min;
        }
    }
}
