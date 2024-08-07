/*
674.
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.
Example 2:

Input: nums = [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
increasing.
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {

        //Brute-force Approach
        // int min= Integer.MIN_VALUE;
        // int len=0;
        // int count=0;
        // int max=Integer.MIN_VALUE;


        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i;j<nums.length-1;j++){
        //         if(nums[j]<nums[j+1]){
        //             count++;
        //         }
        //         else{
                    
        //             break;
        //         }

        //     }
        //     len = Math.max(len,count);
        //             count=0;

        // }

        // return len+1;

        //Optimized Approach


        int left =0;
        int max = Integer.MIN_VALUE;int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                max = Math.max(i-left+1,max);
                //temp = true;
                left =i+1;
            }
            

        }
        max = Math.max(i-left+1,max);
        

        return max;
    }
}
