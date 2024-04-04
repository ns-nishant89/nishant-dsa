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
    public int findlength(ListNode head){
        int length=0;
        while(head!=null){
            length++;
          head=head.next;
        }
        return length;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int length=findlength(head);
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode pre =dummy;
        ListNode cur;
        ListNode next;
        while(length>=k){
            cur=pre.next;
            next=cur.next;
            for(int i=1;i<k;i++){
             cur.next=next.next;
             next.next=pre.next;
             pre.next=next;
             next=cur.next;
             }
             pre=cur;
             length-=k;
         }
          return  dummy.next;
     }
              
 }
