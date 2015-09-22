/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 Hide Tags Linked List

 */


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        //storing each node to the list
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        int size = list.size();
        int count = size % 2==0? size/2 -1 : size/2;
        for(int i=0;i<size;i++){
            /**
             * 1.the middle node will be the last element
             * 2.first half list, each node will point to  form the last element to the middle one
             * 3.last half list, each node will point to from the middle element to the first one
             *
              */

            if(i == size/2){
                list.get(i).next = null;
            }else if(i < size/2){
                list.get(i).next = list.get(size-1-i);
            }else if(i > size/2){
                list.get(i).next = list.get(count--);
            }
        }
    }
}
