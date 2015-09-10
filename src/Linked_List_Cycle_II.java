import java.util.HashSet;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space?
 */
public class Linked_List_Cycle_II {
    //Solution1:usr HashSet
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode result = null;
        while(head!=null){
            if(set.contains(head)){
                result = head;
                break;
            }
            set.add(head);
            head = head.next;
        }
        return result;
    }

    /**
     * Solution2:
     * 1.At fitst we need to judge if there is a cycle
     * 2.if cycle, we find it
     * 3.or return null
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = head.next;
            fast = head.next.next;
            if (slow == fast)break;
        }
        if (fast==null || fast.next==null)return null;

        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
