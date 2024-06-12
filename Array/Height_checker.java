/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
*/


class Solution {
    public int heightChecker(int[] heights) {
        /* 1st Method
         * int count=0;
         * int[] arr = Arrays.copyOf(heights, heights.length);
         * Arrays.sort(heights);
         * for(int i=0;i<heights.length;i++){
         * if(arr[i]!=heights[i]){
         * count++;
         * }
         * }
         * return count;
         * 
         */

        // 2nd Method
        int[] arr = new int[101];
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }
        int j = 1;
        int i = 0;
        int count = 0;
        while (j < 101 && i < heights.length) {
            if (arr[j] != 0) {
                if (heights[i] != j) {
                    count++;

                }
                arr[j]--;
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
