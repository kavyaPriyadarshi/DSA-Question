/*
3264.
You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.

 

Example 1:

Input: nums = [2,1,3,5,6], k = 5, multiplier = 2

Output: [8,4,6,5,6]

Explanation:

Operation	Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]

*/
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // PriorityQueue<List<Integer>> queue = new PriorityQueue<>();

        // PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
        // new Comparator<List<Integer>>() {
        // @Override
        // public int compare(List<Integer> o1, List<Integer> o2) {
        // if(o1.get(1)==o2.get(1)){
        // return Integer.compare(o1.get(0), o2.get(0));
        // }
        // return Integer.compare(o1.get(1), o2.get(1)); // Compare based on the second
        // element
        // }
        // }
        // );
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
                new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> o1, List<Integer> o2) {
                        // Compare by value (second element)
                        int valueComparison = Integer.compare(o1.get(1), o2.get(1));
                        if (valueComparison != 0) {
                            return valueComparison; // If values are different, use this comparison
                        }
                        // If values are the same, compare by index (first element)
                        return Integer.compare(o1.get(0), o2.get(0));
                    }
                });

        List<Integer> list;

        for (int i = 0; i < nums.length; i++) {
            list = new ArrayList<Integer>();
            list.add(i);
            list.add(nums[i]);
            queue.add(list);
        }

        int i = 0;
        while (i < k) {

            List<Integer> element = queue.poll(); // Remove the element
            int newVal = element.get(1) * multiplier;
            element.set(1, newVal); // Modify the element
            queue.offer(element);

            i++;
        }

        int[] result = new int[nums.length];
        for (List<Integer> lt : queue) {
            result[lt.get(0)] = lt.get(1);
        }
        return result;

    }
}
