import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
    1
     \
      2
     /
    3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?


 */
public class Binary_Tree_Inorder_Traversal {
    //Solution1:recursive
    private List<Integer> list;
    public List<Integer> inorderTraversal1(TreeNode root) {
        list = new ArrayList<Integer>();
        helper(root);
        return list;
    }
    private void helper(TreeNode node){
        if(node==null)return;
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }



    //Solution2: iterative
    public List<Integer> inorderTraversal2(TreeNode root){
        ArrayList<Integer> list= new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            //store the left node
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            //traverse the leftest node
            cur = stack.pop();
            list.add(cur.val);
            //如果该点没有右孩子，则继续从stack中取点，如果有，则push该点，并继续沿着该点push所有左孩子
            cur = cur.right;
        }
        return list;
    }


}
