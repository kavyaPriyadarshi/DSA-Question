/*
1493.

Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int max = -1;
        int left=0,right=0;
        int count_zero = 0;

        for(right =0;right<nums.length;right++){
            if(nums[right]==0){
                count_zero++;
            }
            if(count_zero==2){
                
                max = Math.max((right-left - 1),max);
                System.out.println(max);
                while(count_zero!=1){
                    if(nums[left]==0){
                        count_zero--;
                    }
                    left++;
                    
                }
            }
        }

        
        if(count_zero==0){
            return nums.length-1;
        }
        else if(count_zero==1){
            max = Math.max((right-left - 1),max);
            System.out.println(left + " "+max);
        }
        return max;
    }
}
