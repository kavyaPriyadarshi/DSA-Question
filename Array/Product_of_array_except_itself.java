/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightmult = new int[nums.length - 1];
        int[] leftmult = new int[nums.length - 1];
        int mult = 1;
        int index = 0;
        int left = nums.length - 3;
        int right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            mult *= nums[i];
            rightmult[i] = mult;
        }
        mult = 1;
        index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            mult *= nums[i];
            leftmult[index] = mult;
            index++;
        }
        
        nums[0] = leftmult[nums.length - 2];
        nums[nums.length - 1] = rightmult[nums.length - 2];

        int new_size = nums.length - 2;
        int j = 0;
        index = 1;
        while (j < new_size) {
            nums[index] = rightmult[right] * leftmult[left];
            index++;
            right++;
            left--;
            j++;
        }
        return nums;
    }
}
