class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp1 = head;
        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        if (count <= 1) {
            return head;
        } else if (count == 2) {
            if (head.val == head.next.val) {
                head.next = null;
            }
            return head;
        } else {
            ListNode temp2 = head.next;
            while (temp1 != null && temp2 != null) {
                if (temp1.val == temp2.val) {
                    temp1.next = temp2.next;
                    temp2 = temp2.next;
                } else {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
            return head;
        }
    }
}
