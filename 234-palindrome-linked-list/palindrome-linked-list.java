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
    public ListNode reverse(ListNode ptr){
        ListNode pre=null;
        ListNode next=null;
        while(ptr!=null){
            next=ptr.next;
            ptr.next=pre;
            pre=ptr;
            ptr=next;
        }
        return pre; 
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        } 
        slow.next=reverse(slow.next);
        slow=slow.next;
        ListNode dum=head;
        while(slow!=null){
            if(dum.val!=slow.val) return false;
            dum=dum.next;
            slow=slow.next;
        }
        return true;
    }
}