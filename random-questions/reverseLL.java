//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
//https://leetcode.com/problems/reverse-linked-list/

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
        if(head == null)
            return null;
        ListNode cur,prev=null,next = null;
        cur=head;
        while(cur.next!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur =next;
        }
        cur.next=prev;
        return cur;
    }
}
