/**
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 and every parent has two children).
 For example,
 Given the following perfect binary tree,
    1
   /  \
  2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
     1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \  / \
 4->5->6->7 -> NULL
 */

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x){
        val = x;
    }
}

/**
 * 1.if current node has left node,it means they have children nodes in this level.we can do it.
 * 2.Then the left node's next point to the right
 * 3.if currnet node has next node, then  the right node's of current point to the next node's left.
 *   else point to null
 */
public class Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        while(root.left!=null){
            TreeLinkNode node = root;
            while(node!=null){
                node.left.next = node.right;
                node.right.next = node.next==null? null : node.next.left;
                node = node.next;
            }
            root = root.left;
        }
    }
}
