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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carrier = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null || l2 != null || carrier != 0) {

            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;

            int sum = value1 + value2 + carrier;
            carrier = sum / 10;
            int nodeVal = sum % 10;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            current.next = new ListNode(nodeVal);
            current = current.next;
        }

        return dummy.next;
    }
}
