/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                node.next = l2;
                l2 = l2.next;
            }else{
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1==null){
            node.next = l2;
        }
        if(l2 == null){
            node.next = l1;
        }
        return dummy.next;
    }
}
