/*
160.
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
*/


public class Solution {
    int getListLength(ListNode temp){
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //Method - 1
        /*ListNode temp1 = headA;
        ListNode temp2 = headB;
        ListNode ptr = null;
        bb:while(temp1!=null){
            temp2= headB;
            while(temp2!=null){

            if(temp1==temp2){
                ptr = temp1;
                break bb;
            }
             temp2= temp2.next;
            }
            
            temp1= temp1.next;
        }
        return ptr;
        */

        //Method 2

        int len1 = getListLength(headA);
        int len2 = getListLength(headB);

        while(len1<len2){
            len1++;
            headB= headB.next;
        }

        while(len1>len2){
            len2++;
            headA = headA.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB= headB.next;
        }
        return headA;
    }
}
