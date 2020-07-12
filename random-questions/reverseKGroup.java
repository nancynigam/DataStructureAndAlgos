//https://leetcode.com/problems/reverse-nodes-in-k-group/
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/ : for this ques : reverseKGroup(head,2);

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==0 || k==1)
            return head;
        ListNode cur = head;
        ListNode prev=null, next=null;
        int count =0;
        //Below 3 lines are imp only for leetcode ques, can ignore if doing geeksforgeeks version of this problem.
        int len = lengthOfLL(head);
        if(k>len)
            return head;
        while(count<k && cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        
        if(next!=null)
            head.next = reverseKGroup(next,k);
        
        return prev;
    }
    
    public int lengthOfLL(ListNode head){
        if(head == null)
            return 0;
        if(head.next == null)
            return 1;
        ListNode cur = head;
        int count=0;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }
}
