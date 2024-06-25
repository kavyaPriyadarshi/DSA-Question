/*
503.
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.


Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        boolean temp = false;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Stack<Integer> st = new Stack<Integer>();
        int[] arr = new int[nums.length];
        int k = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            k = 0;
            temp = false;
            while (!st.isEmpty()) {
                if (nums[i] >= st.peek()) {
                    st.pop();
                } else {
                    arr[i] = st.peek();
                    temp = true;
                    break;
                }
            }

            while (k < i && temp != true) {
                if (nums[i] < copy[k]) {
                    arr[i] = copy[k];
                    break;

                }
                k++;
            }
            temp = false;

            if (st.isEmpty() && k == i) {
                arr[i] = -1;
            }
            st.push(nums[i]);
        }
        return arr;
    }
}
