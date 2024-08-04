/*
1508.
You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.
 

Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13 
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
*/
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size = n * (n + 1) / 2;
        int[] arr = new int[size];
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            k++;
            arr[k] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                arr[k + 1] = nums[j] + arr[k];
                k++;
            }
        }

        Arrays.sort(arr);

        int sum = 0;
        while (left <= right) {
            sum = sum + arr[left - 1];
            sum = sum % 1000000007;
            left++;

        }
        return sum;
    }
}
