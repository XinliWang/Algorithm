/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
  \
   5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//backtracking
public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        List<TreeNode> list = new ArrayList<>();
        helper(lists,list,root);
        return lists;
    }
    private void helper(List<String> lists ,List<TreeNode> list,TreeNode root){
        //if get to the leaf node
        if(root.left==null && root.right == null){
            StringBuilder builder = new StringBuilder();
            for(TreeNode t: list){
                builder.append(t.val).append("->");
            }
            builder.append(root.val);
            lists.add(builder.toString());
        }
        //backtracking
        list.add(root);
        if(root.left!=null){
            helper(lists,list,root.left);
        }
        if(root.right!=null){
            helper(lists,list,root.right);
        }
        list.remove(list.size()-1);

    }

}
