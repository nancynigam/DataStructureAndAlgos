//https://leetcode.com/problems/middle-of-the-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        int count=0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        int mid = count/2, i =0;
        cur = head;
        while(i<mid){
            cur = cur.next;
            i++;
        }
        return cur;
    }
    
    //In single pass
    public ListNode middleNodeSinglePass(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode p=head,q = head;
        while(q!=null && q.next!=null ){
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
