/*
436.
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
*/

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] arr = new int[intervals.length];
        arr[0]=-1;
        boolean temp=false;
        int min= Integer.MAX_VALUE;
        
        int[] a1 = new int[intervals.length];
        int[] a2 = new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            a1[i]=intervals[i][0];
            a2[i]=intervals[i][1];
        }

        

        for(int i=0;i<a2.length;i++){
            for(int j=0;j<a1.length;j++){
                
                int diff = a1[j]-a2[i];
                
                if(diff>=0){
                    temp=true;
                    if(min>diff){
                        min=diff;
                        arr[i]=j;
                        
                    }
                    
                }

            }
            if(temp==false){
                arr[i]=-1;
            }
            temp=false;
            min=Integer.MAX_VALUE;
        }
        return arr;

    }
}
