/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
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

import java.util.Stack;

/**
 * Solution:
 * 1. This is Binary search tree,so when we use in-order to traverse this tree
 * 2. we can get the ascending array
 * 3. if element is greater than the next, the first element is the what we want
 * 4. the second element what we want is element>cur, the cur is the second element
 */
public class Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode[] target = new TreeNode[2];
        TreeNode previous = new TreeNode(Integer.MIN_VALUE);
        TreeNode cur = root;
        int i=0;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(previous.val>cur.val){
                if(i==0){
                    target[i] = previous;
                    i++;
                }
                target[i] = cur;
            }
            previous = cur;
            cur = cur.right;
        }
        if(target[0]!=null && target[1]!=null){
            int temp;
            temp = target[0].val;
            target[0].val = target[1].val;
            target[1].val = temp;
        }
    }
}
