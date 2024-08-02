/*
202.
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        int sum =0;
        String num = Integer.toString(n);
        HashMap<Character,Integer> mp1 = new HashMap<Character,Integer>();
        boolean temp = true;
        int a =0,i=0;
        int m=48;
        while(a<=9){
            mp1.put((char)m,a*a);
            a++;
            m++;
        }
        if(num.length()==1 && num.charAt(0)==49){
            return true;
        }
        
        bb:while(sum!=1){
            i=0;
        while(i<num.length()){
            char ch = num.charAt(i);
            int x = mp1.get(ch);
            sum = sum + x;

            i++;


        }
        if(sum==1){
            temp = true;
            break bb;
        }
        else if(sum<7){
            temp = false;
            break bb;
        }
        else{
            num = Integer.toString(sum);
            sum =0;
            i=0;
        }
        
        }
        return temp;


    }
}
