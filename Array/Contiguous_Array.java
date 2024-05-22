class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(sum, -1);
        int max_length = 0, length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + 1;
            }
            if (mp.containsKey(sum)) {
                length = i - mp.get(sum);

            } else {
                mp.put(sum, i);
            }
            if (max_length < length) {
                max_length = length;
            }
        }
        return max_length;
    }
}
