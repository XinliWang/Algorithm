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
    //Solution1：Recursive, use list
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

    //Solution2: Recursive , use the second help function
    private List<Integer> list;
    public List<Integer> preorderTraversal2(TreeNode root) {
        list = new ArrayList<Integer>();
        helper(root);
        return list;
    }
    private void helper(TreeNode node){
        if(node==null)return;
        list.add(node.val);
        helper(node.left);
        helper(node.right);
    }
    /**
     * Solution3：Iterative:
     * 1.each time add right first and then left node to stack
     * 2.each time only pop one node
     * 3.add every element to the list
     */

    public List<Integer> preorderTraversal3(TreeNode root){
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

    /**
     * Solution4:Iterative
     * 1.Before push node to stack, add the value to the list
     * 2.each time, traverse all left node of one side, add and push
     * 3.then pop one node, and get its right node. Then continue from 2
     */
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> stack = new Stack<>();
        list.add(root.val);
        stack.push(root);
        while(!stack.isEmpty()){
            while(root.left!=null){
                root = root.left;
                list.add(root.val);
                stack.push(root);
            }
            TreeNode node = stack.pop();
            if(node.right!=null){
                root = node.right;
                stack.push(root);
                list.add(root.val);
            }
        }
        return list;
    }
}
