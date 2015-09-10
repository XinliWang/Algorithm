import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Path_Sum {
    //回朔法：recursive
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return (sum==root.val);
        }
        return hasPathSum(root.left,sum - root.val)||hasPathSum(root.right,sum - root.val);
    }

    /**
     * DFS和stack：iterative,每次把右孩子和左孩子依次放入stack中，把sum-val当前剩余值放入stackVal中，
     * 每次取出一个,原理跟先序遍历相同。
     */
    public boolean hasPathSum2(TreeNode root,int sum){
        if(root==null)return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        stack.push(root);
        stackVal.push(sum - root.val);
        while(!stack.isEmpty() && root!=null){
            TreeNode node = stack.pop();
            int num = (int)stackVal.pop();
            if (node.left==null && node.right==null && num==0){
                return true;
            }
            if(node.right!=null){
                stack.push(node.right);
                stackVal.push(num-node.right.val);
            }
            if(node.left!=null){
                stack.push(node.left);
                stackVal.push(num-node.left.val);
            }
        }
        return false;
    }
}
