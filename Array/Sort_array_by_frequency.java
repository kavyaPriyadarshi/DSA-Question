/*
1636.
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
*/

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            list.add(nums[i]);
        }

        int[] arr = new int[nums.length];
        Collections.sort(list, (k1, k2) -> {
            int freq1 = mp.get(k1);
            int freq2 = mp.get(k2);

            if (freq1 != freq2) {
                return freq1 - freq2;
            }
            return k2 - k1;
        });

        int k = nums.length - 1;
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
            k--;
        }

        return nums;
    }
}
