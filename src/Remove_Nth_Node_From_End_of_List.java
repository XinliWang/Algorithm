/**
 * Given a linked list, remove the nth node from the end of list and return its head.
   For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head,int n){
        if(n==0)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index= head;
        for(int i=0;i<n;i++){
            head = head.next;
        }
        if(head==null)return index.next;
        while(head.next!=null){
            head = head.next;
            index = index.next;
        }
        index.next = index.next.next;
        return dummy.next;
    }

}
 class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}