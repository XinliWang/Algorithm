/**
 * Sort a linked list using insertion sort.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode dummy = new ListNode(0);
        while(cur!=null){
            ListNode node = dummy;
            //find the right position to insert,we need not consider the first time, node.next is null
            while(node.next != null && node.next.val<cur.val){
                node = node.next;
            }
            //insert between node and node.next
            cur.next = node.next;
            node.next = cur;
            //execute the next node
            cur = next;

        }
        return dummy.next;
    }
}
