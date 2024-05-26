/*
You are given an array nums, where each number in the array appears either once or twice.

Return the bitwise XOR of all the numbers that appear twice in the array, or 0 if no number appears twice.

Example 1:
Input: nums = [1,2,1,3]

Output: 1
*/

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        List<Integer> lt = new ArrayList<Integer>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
            } else {
                lt.add(nums[i]);
            }
        }
        if (lt.size() == 0) {
            return 0;
        } else if (lt.size() == 1) {
            return lt.get(0);
        } else {
            result = lt.get(0) ^ lt.get(1);
            for (int i = 2; i < lt.size(); i++) {
                result = result ^ lt.get(i);
            }
            return result;
        }
    }
}
