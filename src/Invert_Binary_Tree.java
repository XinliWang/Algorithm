import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

       4
     /   \
    2     7
   / \   / \
  1   3 6   9

 to
       4
     /   \
    7     2
   / \   / \
  9   6 3   1
 */
//use BFS

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root){
        if(root==null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode replace = null;
        TreeNode node = null;
        int size = 0;
        while (!queue.isEmpty()){
            size = queue.size();

            for(int i =0;i<size;i++){
                node = queue.poll();
                
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                replace = node.left;
                node.left = node.right;
                node.right = replace;
            }
        }
        return root;
    }
}
