/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //head一直往前指向不重复的元素，pre指向重复元素的前一个元素
        while(head!=null){
            //判断此时后面的元素重不重复，一直向前直到确保没有重复元素，再进行pre指针操作
            if(head.next!=null && head.val == head.next.val){
                int temp = head.val;
                //向前移动到不重复的元素
                while(head!=null && temp == head.val){
                    head = head.next;
                }
            }else{
                pre.next = head;
                pre = pre.next;
                head = head.next;
            }

        }
        pre.next = null;
        return dummy.next;
    }

}
