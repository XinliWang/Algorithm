import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path
 from the root node down to the farthest leaf node.
 */


public class Maximum_Depth_of_Binary_Tree {
    //法一：recursive
    public int maxDepth(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //法二：BFS
    public int maxDepth2(TreeNode root){
        int level=0;
        if(root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

}
