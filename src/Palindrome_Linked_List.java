/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */

import java.util.LinkedList;

/**
 * Using LinkedList,each time poll first and last element
 * time cost:O(n), space cost:O(n)
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head){
        LinkedList<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        while(list.size()>1){
            if(list.pollFirst().equals(list.pollLast())){
                return false;
            }
        }
        return true;
    }
}
