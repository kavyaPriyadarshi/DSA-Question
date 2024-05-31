/*Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
*/
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int ans = 1000001;
        HashSet<Integer> st = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.min(ans, matrix[i][j]);
            }

            arr[i] = ans;
            ans = 1000001;

        }
        ans = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ans = Math.max(ans, matrix[j][i]);
            }

            st.add(ans);
            ans = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (st.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
