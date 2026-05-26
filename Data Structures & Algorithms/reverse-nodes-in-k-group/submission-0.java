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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode back = dummy;
        while(true){
            ListNode kth = findKth(back,k);
            if(kth==null)break;
            ListNode front = kth.next;
            ListNode prev = kth.next;
            ListNode cur = back.next;
            while(cur!=front){
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            ListNode tmp = back.next;
            back.next = kth;
            back = tmp;
        }
        return dummy.next;
    }
    public ListNode findKth(ListNode l1 , int k){
        while(l1 != null && k>0){
            l1 = l1.next;
            k--;
        }
        return l1;
    }
}
