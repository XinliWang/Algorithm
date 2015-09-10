import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
    1
     \
      2
     /
    3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Preorder_Traversal {
    //方法一：Recursive
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            list.add(root.val);
            List<Integer> leftList = preorderTraversal(root.left);
            List<Integer> rightList = preorderTraversal(root.right);
            list.addAll(leftList);
            list.addAll(rightList);
        }
        return list;
    }

    /**
     * 方法二：Iterative:
     * 1.each time add right and left node to stack
     * 2.each time only pop one node
     * 3.add every element to the list
     */


    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root!=null && stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return list;
    }
}
