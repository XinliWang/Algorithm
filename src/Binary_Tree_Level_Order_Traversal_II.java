import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
 return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3]
     ]
 */
public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<Integer> subList = new ArrayList<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        if(root==null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.addFirst(subList);
            subList = new ArrayList<Integer>();
        }
        return list;
    }
}
