/*
4.
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = (nums1.length + nums2.length)/2 +1;
        int[] arr = new int[size];
        int k=0;
        int i=0;
        int j=0;
        while(k<size && i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else if(nums1[i]>nums2[j]){
                arr[k] = nums2[j];
                k++;
                j++;
            }
            else{
                arr[k] = nums1[i];
                i++;
                k++;
            }
        }

        if(k!=size){
            if(i<nums1.length){
                while(i<nums1.length && k<size){
                    arr[k] = nums1[i];
                    k++;
                    i++;
                }
            }
            else{
                while(j<nums2.length && k<size){
                    arr[k] = nums2[j];
                    k++;
                    j++;
                }
            }
        }
        if((nums1.length+nums2.length)%2!=0){
            return arr[arr.length-1];
        }
        else{
            return ((double)(arr[arr.length-1] + arr[arr.length-2])/2);
        }
    }
}
