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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
     int firstCriticalpt =-1;
     int prevCriticalpt=-1;
     int currind=1;
     ListNode curr=head.next;
     ListNode prev = head;
     int [] res = new int[2];
     res[0] = Integer.MAX_VALUE;
     while(curr.next!=null){
        ListNode nextnode = curr.next;
        if((curr.val<prev.val && curr.val<nextnode.val) || (curr.val>prev.val && curr.val>nextnode.val)){
           if(prevCriticalpt==-1){
            prevCriticalpt =currind;
            firstCriticalpt=currind;
           }else{
            res[0] =Math.min(res[0],currind-prevCriticalpt);
            prevCriticalpt=currind;
           }
        }
        prev=prev.next;
        curr=curr.next;
        currind++;
        }
        if(firstCriticalpt!=-1 && res[0]!=Integer.MAX_VALUE){
            res[1]= prevCriticalpt-firstCriticalpt;
        }else{
            res[0]=-1;
            res[1]=-1;
        }  
     return res;
    }
}