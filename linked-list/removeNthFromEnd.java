/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //1 more solution is possible with 2 pointers.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        int len=calLen(head);
        //System.out.println("len = "+len);
        if(len==1 && n==1)
            return null;
        ListNode cur=head;
        int x=len-n-1;
        int index=0;
        //System.out.println("x = "+x);
        if(len == n)
            return head.next;
        while(cur!=null && index<x){
            cur=cur.next;
            //System.out.println("index = "+index);
            index++;
        }
        if(cur!=null && cur.next!=null)
            cur.next=cur.next.next;
        return head;
    }
    
    public int calLen(ListNode head){
        int len=0;
        ListNode node=head;
        while(node!=null) {
            len++;
            node=node.next;
        }
        return len;
    }
}
