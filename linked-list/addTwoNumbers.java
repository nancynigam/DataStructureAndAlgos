/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode head = new ListNode(0);
        ListNode p=l1,q=l2,cur=head;
        int carry=0;
        while(p!=null || q!=null) {
            int x = (p !=null ? p.val:0);
            int y = (q !=null ? q.val:0);
            int sum = x+y+carry;
            carry=sum/10;
            cur.next = new ListNode(sum%10);
            if(p!=null)
                p=p.next;
            if(q!=null)
                q=q.next;
            cur=cur.next;
        }
      
        if(carry>0)
            cur.next = new ListNode(1);

        return head.next;
    }
}
