/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode cur=head;
        ListNode next=null;
        ListNode prev=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        return head;
            
    }
}
