/*
3232.
ou are given an array of positive integers nums.

Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers or all double-digit numbers from nums, and the rest of the numbers are given to Bob. Alice wins if the sum of her numbers is strictly greater than the sum of Bob's numbers.

Return true if Alice can win this game, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4,10]

Output: false

Explanation:

Alice cannot win by choosing either single-digit or double-digit numbers.

*/

class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1=0,sum2=0;
        for(int ele:nums){
            if(ele<10){
                sum1 +=ele;
            }
            else{
                sum2 +=ele;
            }
        }
        if(sum1==sum2){
            return false;
        }
        return true;
    }
}
