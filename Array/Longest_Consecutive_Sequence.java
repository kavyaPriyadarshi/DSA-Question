/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hs = new HashMap<Integer,Boolean>();
        //int j=i;
        int count1=0,count2=0,sum=0,len=0,ele=0;
        for(int i=0; i<nums.length ; i++)
        {
            hs.put(nums[i],false);
        }
        for(int i=0;i<nums.length;i++)
        {
            ele=nums[i];
            while(hs.containsKey(ele) && hs.get(ele)==false)
            {
                count1++;
                hs.replace(ele,true);
                ele++;
            }
            ele=nums[i]-1;
            while(hs.containsKey(ele) && hs.get(ele)==false)
            {
                count2++;
                hs.replace(ele,true);
                ele--;
            }
            if(len<(count1 + count2))
            {
                len=count1+count2;
            }
            count1=0;
            count2=0;
        }
        return len;
    }
}
