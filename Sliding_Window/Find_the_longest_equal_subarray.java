/*
2831.
You are given a 0-indexed integer array nums and an integer k.

A subarray is called equal if all of its elements are equal. Note that the empty subarray is an equal subarray.

Return the length of the longest possible equal subarray after deleting at most k elements from nums.

A subarray is a contiguous, possibly empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,1,3], k = 3
Output: 3
Explanation: It's optimal to delete the elements at index 2 and index 4.
After deleting them, nums becomes equal to [1, 3, 3, 3].
The longest equal subarray starts at i = 1 and ends at j = 3 with length equal to 3.
It can be proven that no longer equal subarrays can be created.
*/
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> list;
        List<Integer> lt;

        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                list = map.get(nums.get(i));
                list.add(i);
                map.replace(nums.get(i), list);
            } else {
                lt = new ArrayList<Integer>();
                lt.add(i);
                map.put(nums.get(i), lt);
            }

        }

        int max = 1;
        for (int key : map.keySet()) {
            List<Integer> list1 = map.get(key);
            int left = 0;
            int right = 0;
            int sum = 0;

            for (right = 1; right < list1.size(); right++) {
                sum = sum + ((list1.get(right) - list1.get(right - 1)) - 1);

                while (sum > k && left < right) {
                    sum -= (list1.get(left + 1) - list1.get(left) - 1);
                    left++;
                }
                max = Math.max(max, right - left + 1);

            }
        }
        return max;
    }
}
