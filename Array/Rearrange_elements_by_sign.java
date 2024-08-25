/*
2149.
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions. 
*/


class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }
        
        int k=0;
        for(int j=0;j<nums.length;j +=2){
            result[j] = list2.get(k);
            result[j+1]=list1.get(k);
            k++;

        }
        return result;


        //OR SECOND METHOD


        int even_index = 0;
        int odd_index  =1;

        int[]  result = new int[nums.length];


        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result[even_index]=nums[i];
                even_index +=2;
            }
            else{
                result[odd_index] = nums[i];
                odd_index +=2;
            }
        }
        return result;
    }
}