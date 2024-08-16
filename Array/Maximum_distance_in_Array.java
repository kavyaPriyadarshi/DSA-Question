/*
624.
You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance.

 

Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Example 2:

Input: arrays = [[1],[1]]
Output: 0

*/
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> list;
        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        int index_min = 0, index_max = 0;

        for (int i = 0; i < arrays.size(); i++) {
            list = arrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (min > list.get(j)) {
                    min = list.get(j);
                    index_min = i;
                }
            }
        }

        for (int i = 0; i < arrays.size(); i++) {
            list = arrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == index_min) {
                    break;
                }
                if (max < list.get(j)) {
                    max = list.get(j);
                    // index_max =i;
                }
            }
        }

        int x = Math.abs(max - min);
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            list = arrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (max < list.get(j)) {
                    max = list.get(j);
                    index_max = i;
                }
            }
        }

        for (int i = 0; i < arrays.size(); i++) {
            list = arrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == index_max) {
                    break;
                }
                if (min > list.get(j)) {
                    min = list.get(j);
                    // index_max =i;
                }
            }
        }

        return Math.max(x, Math.abs(max - min));

    }
}
