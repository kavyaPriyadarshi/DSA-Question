/*
219.
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> mp1 = new HashMap<Integer,Integer>();
        boolean temp = false;

        for(int i=0;i<nums.length;i++){
            if(mp1.containsKey(nums[i])){
                int index = mp1.get(nums[i]);
                int diff = Math.abs(i-index);
                if(diff<=k){
                    temp = true;
                    break;
                }
                else{
                    mp1.replace(nums[i],i);
                }
            }
            else{
                mp1.put(nums[i],i);
            }
        }
        return temp;
    }
}
