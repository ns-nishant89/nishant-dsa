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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head.next;
        ListNode temp = node;
        while(temp!=null){
            //find sum within the block
            int sum=0;
            while(temp.val!=0){
               sum+=temp.val;
               temp = temp.next; 
            }
            //update the value
            node.val=sum;
            //move temp to next block
            temp=temp.next;
            //connect next block
            node.next=temp;
            //move node to next block
            node =temp;
        }
        head = head.next;
        return head;
    }
}