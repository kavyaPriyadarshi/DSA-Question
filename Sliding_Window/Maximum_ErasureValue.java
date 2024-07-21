/*
1695.

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
Return the maximum score you can get by erasing exactly one subarray.
An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
*/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        //BRUTE FORCE
        
        HashSet<Integer> st = new HashSet<Integer>();
        int sum=0;
        int max=0,index=-1;
        /*for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(!st.contains(nums[j])){
                    sum = sum + nums[j];
                    st.add(nums[j]);
                }
                else{
                    //if(index<=(j-i)){
                        max = Math.max(max,sum);
                    //}
                    //sum=0;
                    st.clear();
                    break;
                }
                

            }
            max = Math.max(max,sum);
            sum=0;
            //max = Math.max(max,sum);
            
        }
        return max;
        */

        //OPTIMIZED CODE


            int left =0;
            int right=0;

            for(right=0;right<nums.length;right++){
                if(!st.contains(nums[right])){
                    sum = sum+nums[right];
                    st.add(nums[right]);
                }
                else{
                    max = Math.max(max,sum);
                    while(nums[left]!=nums[right]){
                        st.remove(nums[left]);
                        sum = sum - nums[left];
                        left++;
                    }
                    left++;
                }
                if(right==nums.length-1){
                    max = Math.max(max,sum);
                }
            }
            return max;
    }
}
