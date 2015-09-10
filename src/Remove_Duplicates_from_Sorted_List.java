/**
 *Given a sorted linked list,
 * delete all duplicates such that each element appear only once.
   For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head){
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        head = head.next;
        while(head!=null){
            if(prev.val==head.val){
                head = head.next;
            }else{
                prev.next = head;
                prev = head;
                head = head.next;
            }
        }
        prev.next = head;
        return dummy.next;
    }
}
