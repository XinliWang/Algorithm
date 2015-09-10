/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head){
        if(head==null)return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = null;

        while(cur!=null && cur.next!=null){
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = cur;
            cur = cur.next;

        }
        return dummy.next;

    }
}
