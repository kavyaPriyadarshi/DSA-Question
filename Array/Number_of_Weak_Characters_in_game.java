/*
1996.
You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
*/

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        // BRUTE-FORCE APPROACH
        /*
        int count =0;
        boolean temp = false;
        for(int i = 0;i<properties.length;i++){
            for(int j = 0;j<properties.length;j++){
                if(properties[i][0]< properties[j][0] && properties[i][1] < properties[j][1]){
                    temp = true;
                }
            }
            if(temp == true){
                count++;
            }
            temp = false;
        }
        return count;
        */

        // OPTIMIZED APPROACH
        int count =0;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<properties.length;i++){
            int[] arr = new int[2];
            arr[0] = properties[i][0];
            arr[1] = properties[i][1];
            list.add(arr);
        }

        Collections.sort(list,(a,b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });

        int min = Integer.MIN_VALUE;
        int[] arr;
        for(int i=list.size()-1; i>=0;i--){
            arr = list.get(i);
            if(arr[1]>= min){
                min = arr[1];
            }
            else{
                count ++;
            }
        }
        return count;



    }
}
