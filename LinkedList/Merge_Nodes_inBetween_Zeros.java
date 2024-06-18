/*
You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

Example 1:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
*/

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode ptr = null;
        ListNode head1=null;
        int sum=0;
        while(temp!=null){
            if(temp.val!=0){
                sum=sum+temp.val;
            }
            if(temp.val==0 && temp !=head){
                
                if(ptr==null){
                    head1 = new ListNode();
                    head1.val = sum;
                    ptr=head1;
                }
                else{
                    ListNode temp1 = new ListNode();
                    temp1.val = sum;
                    ptr.next = temp1;
                    ptr= ptr.next;
                }
                sum=0;
            }
            temp  = temp.next;
        }
        return head1;
    }
}
