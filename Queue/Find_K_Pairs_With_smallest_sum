/*
373.
ou are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
*/

class Solution {

    class Triple {
        int val;
        int index1;
        int index2;

        public Triple(int num, int idx1, int idx2) {
            val = num;
            index1 = idx1;
            index2 = idx2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (pq.size() < k) {
                    pq.add(new Triple((nums1[i] + nums2[j]), i, j));

                } else if (pq.peek().val > (nums1[i] + nums2[j])) {
                    pq.poll();

                    pq.add(new Triple((nums1[i] + nums2[j]), i, j));
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pq.peek().index1]);
            list.add(nums2[pq.peek().index2]);
            result.add(list);
            pq.poll();

        }
        Collections.reverse(result);
        return result;

    }
}

