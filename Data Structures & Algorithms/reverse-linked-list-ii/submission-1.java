class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find the node before 'left'
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // First node of the section to reverse
        ListNode curr = before.next;

        // Reverse using the traditional method
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the reversed section back
        before.next.next = curr;
        before.next = prev;

        return dummy.next;
    }
}