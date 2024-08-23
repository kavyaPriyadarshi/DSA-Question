/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            
            
                mp.put(arr[i],Math.abs(arr[i]-x));
                list.add(arr[i]);
            
        }

        
        Collections.sort(list , (k1,k2)->{
            int val1 = mp.get(k1);
            int val2 = mp.get(k2);


            if (val1 == val2) {
        return k1 - k2; // Sort by the element's value if the differences are the same
    } else {
        return val1 - val2; // Sort by the difference
    }
        });
        

        for(int i=0;i<k;i++){
            list2.add(list.get(i));
        }
        
        Collections.sort(list2);
        return list2;
    }
}
