/*
2807.
Given the head of a linked list head, in which each node contains an integer value.
Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
Return the linked list after insertion.
The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
Example 1:

Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]

*/

class Solution {

    int Find_GCD(int n1,int n2){
            int val =0;
            int i=0;
            if(n1<n2){
                val=n1;
            }
            else{
                val = n2;
            }
            for(i = val ;i>=1;i--){
                if(n1%i==0 && n2%i==0){
                    break;
                }
            }
            return i;

        }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode temp = head;
        int num1= 0;
        int num2=0;
        int result=0;
        while(temp.next!=null){
            ListNode ptr= new ListNode();
            num1= temp.val;
            num2= temp.next.val;
            ptr.val = Find_GCD(num1,num2);
            ptr.next = temp.next;
            temp.next = ptr;
            temp = ptr.next;
        }

        
        return head;
    }
}
