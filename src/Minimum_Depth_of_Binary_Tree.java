import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.

   The minimum depth is the number of nodes along the shortest path
   from the root node down to the nearest leaf node.

 Example
 Given a binary tree as follow:

    1

 /     \

 2       3

       /    \

      4      5

 The minimum depth is 2

 Tags Expand
 Depth First Search
 */
public class Minimum_Depth_of_Binary_Tree {
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
    //方法一：recursion,DFS
    public int minDepth(TreeNode root){
        if(root==null)return 0;
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

    //方法二：BFS, the first leaf we get is the minimum depth node
    public int minDepth2(TreeNode root){
        if(root==null)return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNum = 0;
        int lastNum = 1;
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            --lastNum;
            if(cur.left==null&&cur.right==null){
                return level;
            }
            if(cur.left!=null){
                queue.offer(cur.left);
                ++curNum;
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                ++curNum;
            }
            if(lastNum==0){
                lastNum = curNum;
                curNum = 0;
                ++level;
            }
        }
        return 0;
    }
    //方法三：BFS,直接for循环
    public int minDepth3(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                if(node.left==null && node.right==null)return count;
            }
            count++;
        }
        return count;
    }
}
