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
    public ListNode insertnode(ListNode head,int val){
        ListNode newNode =  new ListNode(val);
        if(head==null){
            head = newNode;
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null) temp=temp.next;
        temp.next =newNode;
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
      if(head==null|| head.next==null|| k==0) return head;
      //create one head and length
     ListNode temp = head;
      int len = 1;
      //traverse till last and calculate length and temp
      while(temp.next!=null){
       len++;
       temp=temp.next;
      } 
      temp.next=head;
      k=k%len;
      int end = len-k;
      //connect last node to head after rotaion to head and null and then return head
      while(end--!=0) temp=temp.next;
      head=temp.next;
      temp.next=null;
      return head;
    }
}