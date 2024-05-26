/*
You are given an integer array nums, an integer array queries, and an integer x.

For each queries[i], you need to find the index of the queries[i]th occurrence of x in the nums array. If there are fewer than queries[i] occurrences of x, the answer should be -1 for that query.

Return an integer array answer containing the answers to all queries.

Example 1:
Input: nums = [1,3,1,7], queries = [1,3,2,4], x = 1
Output: [0,-1,2,-1]
*/
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int size = 0;
        if (queries.length > nums.length) {
            size = queries.length + 1;
        } else {
            size = nums.length + 1;
        }
        int[] arr = new int[queries.length];
        int[] arr2 = new int[size];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) {
                count++;
                if (i == 0) {
                    arr2[count] = -1;
                } else {
                    arr2[count] = i;
                }

            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > count) {
                arr[i] = -1;
            } else if (queries[i] <= count) {
                if (arr2[queries[i]] != 0) {
                    if (arr2[queries[i]] == -1) {
                        arr[i] = 0;
                    } else {
                        arr[i] = arr2[queries[i]];
                    }
                }

                else {
                    arr[i] = -1;
                }
            }
        }
        return arr;
    }
}
