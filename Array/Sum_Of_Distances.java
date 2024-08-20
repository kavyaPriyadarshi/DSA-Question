/*
You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.

Return the array arr.

 

Example 1:

Input: nums = [1,3,1,1,2]
Output: [5,0,3,4,0]
Explanation: 
When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5. 
When i = 1, arr[1] = 0 because there is no other index with value 3.
When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3. 
When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4. 
When i = 4, arr[4] = 0 because there is no other index with value 2. 

Example 2:

Input: nums = [0,5,3]
Output: [0,0,0]
Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.
*/


class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        long[] arr = new long[nums.length];
        List<Integer> lt;
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(nums[i])) {
                lt = hs.get(nums[i]);
                lt.add(i);
                hs.replace(nums[i], lt);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hs.put(nums[i], list);
            }
        }

        long sum = 0;
        long x = 0;
        for (Integer key : hs.keySet()) {
            List<Integer> list2 = hs.get(key);
            long[] arr1 = new long[list2.size()];
            long[] arr2 = new long[list2.size()];

            if (list2.size() == 1) {
                arr[list2.get(0)] = 0;
            } else {
                for (int j = 0; j < arr1.length; j++) {
                    x += (long) list2.get(j);
                    arr1[j] = x;
                }
                x = 0;

                for (int k = arr2.length - 1; k >= 0; k--) {
                    x += (long) list2.get(k);
                    arr2[k] = x;

                }
                x=0;

                for (int l = 0; l < list2.size(); l++) {
                    if (l == 0) {
                        // First element, no left prefix
                        arr[list2.get(l)] = (long) arr2[l] - ((long) list2.get(l) * list2.size());
                    } else if (l == list2.size() - 1) {
                        // Last element, no right suffix
                        arr[list2.get(l)] = (long) list2.get(l) * list2.size() - arr1[l];
                    } else {
                        // Middle elements, include both prefix and suffix
                        sum = Math.abs((long) arr1[l - 1] - (long) list2.get(l) * l);
                        sum += Math.abs((long) arr2[l] - (long) list2.get(l) * (list2.size() - l));
                        arr[list2.get(l)] = sum;
                    }
                }

            }

        }
        return arr;
    }
}
