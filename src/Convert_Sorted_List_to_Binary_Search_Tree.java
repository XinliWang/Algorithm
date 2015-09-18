/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        if(head.next==null)return new TreeNode(head.val);
        ListNode prev = null;
        ListNode cur = head;
        ListNode runner = head;
        //when break out,cur is in the middle of List,runner has been in the last position
        while(runner !=null && runner.next!=null){
            prev = cur;
            cur = cur.next;
            runner = runner.next.next;
        }
        TreeNode root = new TreeNode(cur.val);
        //break one list to two lists, then get the next node recursively
        if(prev!=null){
            prev.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(cur.next);
        return root;
    }
}
