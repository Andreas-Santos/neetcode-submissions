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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }

        ListNode merged = lists[0];
        for(int i = 1; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }

        return merged;
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null) {

            if(l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if(l1 != null) {
            current.next = l1;
        }
        else {
            current.next = l2;
        }

        return dummy.next;
    }
}
