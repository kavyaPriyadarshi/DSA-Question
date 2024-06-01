/*
Leetcode-566

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
*/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int index = 0;
        if ((r * c) == (m * n)) {
            int[] arr = new int[m * n];
            int[][] result = new int[r][c];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    index = i * n + j;
                    arr[index] = mat[i][j];
                }
            }
            index = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = arr[index];
                    index++;

                }
            }
            return result;
        } else {
            return mat;
        }
    }
}

