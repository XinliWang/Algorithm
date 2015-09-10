/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            head = head.next;
            fast = fast.next.next;
            if (head == fast){
                return true;
            }
        }
        return false;
    }
}
