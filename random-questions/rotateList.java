//https://www.geeksforgeeks.org/rotate-a-linked-list/
//https://leetcode.com/problems/rotate-list/
// Edge cases : if k=0 || len=1 : no change; k>len : k=k%len && again k=0 => no change
//approach: keep a prev pointer which will point to new head and join the end of the LL to the actual head
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        int len = lengthOfLL(head);
        int k = k%len;
        int pos = len-k;
        if(len==1 || k==0)
            return head;
        ListNode prev=head,cur=head;
        int i=0;
        while(cur!=null && i<pos){
            prev=cur;
            cur=cur.next;
            i++;
        }
        prev.next = null;
        ListNode newHead = cur;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
    
    public int lengthOfLL(ListNode head){
        ListNode cur = head;
        int count=0;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }
}
