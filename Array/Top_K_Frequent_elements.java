/*
347.
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency_map = new HashMap<Integer,Integer>();

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int ele:nums){
            frequency_map.put(ele,frequency_map.getOrDefault(ele,0) + 1);
        }

        for(int key : frequency_map.keySet()){
            int frqncy = frequency_map.get(key);
            if(bucket[frqncy]==null){
                bucket[frqncy] = new ArrayList<Integer>();
            }
            bucket[frqncy].add(key);
        }

        int result[] = new int[k];
        int counter=0;
        int i=0;
        for(int pos = bucket.length-1;pos>=0 && counter<k; pos--){
            if(bucket[pos]!=null){
                for(Integer temp : bucket[pos]){
                    result[counter]=temp;
                    counter++;
                    if(counter>k){
                        break;
                    }                 
                }
            }
        }
        return result;

    }
}
