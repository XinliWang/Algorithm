/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Delete_Node_in_a_Linked_List {
    /**
     *  1.The very important thing is given only by this deleted node
     *  2.we can change value, and delete the next node
     */
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
