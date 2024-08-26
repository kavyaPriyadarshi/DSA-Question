/*
2352.
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
*/
class Solution {
    public int equalPairs(int[][] grid) {
        
        HashMap<List<Integer>,Integer> map1 = new HashMap<>();
        HashMap<List<Integer>,Integer> map2 = new HashMap<>();

        List<Integer> list;

        for(int i=0;i<grid.length;i++){
            list = new ArrayList<Integer>();
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
            map1.put(list,map1.getOrDefault(list,0)+1);
            
        }

        for(int i=0;i<grid[0].length;i++){
            list = new ArrayList<Integer>();

            for(int j=0;j<grid.length;j++){
                list.add(grid[j][i]);
            }
            map2.put(list,map2.getOrDefault(list,0)+1);
            
        }
        int count=0;
       
        


        for (List<Integer> list1 : map1.keySet()) {
            if(map2.containsKey(list1)){
                int freq1 = map1.get(list1);
                int freq2 = map2.get(list1);
                count += freq1*freq2;
            }
        }
        return count;
    }
}
