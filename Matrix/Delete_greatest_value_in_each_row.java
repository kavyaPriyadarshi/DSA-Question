/*
2500.
You are given an m x n matrix grid consisting of positive integers.

Perform the following operation until grid becomes empty:

Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
Add the maximum of deleted elements to the answer.
Note that the number of columns decreases by one after each operation.

Return the answer after performing the operations described above.

 

Example 1:


Input: grid = [[1,2,4],[3,3,1]]
Output: 8
Explanation: The diagram above shows the removed values in each step.
- In the first operation, we remove 4 from the first row and 3 from the second row (notice that, there are two cells with value 3 and we can remove any of them). We add 4 to the answer.
- In the second operation, we remove 2 from the first row and 3 from the second row. We add 3 to the answer.
- In the third operation, we remove 1 from the first row and 1 from the second row. We add 1 to the answer.
The final answer = 4 + 3 + 1 = 8.
*/

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        List<Integer> list = new ArrayList<Integer>();
        int[] compare = new int[grid[0].length];
        int[] arr = new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[j] = grid[i][j]; 
            }
            Arrays.sort(arr);
            for(int k=0;k<compare.length;k++){
                compare[k] = Math.max(compare[k],arr[k]);
            }


        }

        int sum =0;
        for(int m=0;m<compare.length;m++){
            sum += compare[m];
        }
        return sum;
    }
}
