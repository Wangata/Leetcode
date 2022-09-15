/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = l1, q = l2, f = fakeHead;
        int val = 0, offset = 0;
        while(p != null || q != null){
            if(p != null && q != null){
                val = p.val + q.val + offset;
                f.next = new ListNode(val % 10);
                offset = val / 10;
                p = p.next;
                q = q.next;
            }else if(p != null){
                val = p.val + offset;
                f.next = new ListNode(val % 10);
                offset = val / 10;
                p = p.next;
            }else{
                val = q.val + offset;
                f.next = new ListNode(val % 10);
                offset = val / 10;
                q = q.next;
            } 
            f = f.next;
        }
        if(offset == 1){
            f.next = new ListNode(1);
        }
        return fakeHead.next;
    }
}