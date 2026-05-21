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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode curr = null;
        while(l2!=null){
            ListNode temp = l2.next;
            l2.next=curr;
            curr = l2;
            l2=temp;
        }
        while(curr!=null && l1!=null){
            ListNode temp = l1.next;
            l1.next = curr;
            l1 = curr;
            curr = temp;
        }
    }
}
