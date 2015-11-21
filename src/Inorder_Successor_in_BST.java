/**
 * Given a binary search tree and a node in it,
 * find the in-order successor(the next node of this specific node) of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.
 */


import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Inorder_Successor_in_BST {
    /**
     * Solution1：Recursive
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> list = new ArrayList<>();
        helper(list,root);
        int index = -1;
        for(index=0;index<list.size();index++){
            if(list.get(index).val==p.val){
                break;
            }
        }
        if(index == list.size()-1)return null;
        return list.get(index+1);
    }

    private void helper(ArrayList<TreeNode> list,TreeNode node){
        if (node == null)return;
        helper(list,node.left);
        list.add(node);
        helper(list,node.right);
    }


    /**
     * Solution2:Iterative
     * BST is a sorted tree, we can compare in every step.
     * Remember: we need record the bigger node before step into next loop.
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while(root!=null){
            if(p.val<=root.val){
                result = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return result;
    }

}
