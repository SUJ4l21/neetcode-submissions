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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            count++;
        }
        count-=n;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        temp.next = head;
        while(count>0){
            temp=temp.next;
            count--;
        }
        if(temp.next!=null && temp.next.next!=null){
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
        return dummy.next;
    }
}
