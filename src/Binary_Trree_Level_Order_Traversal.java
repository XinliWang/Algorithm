import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
         3
        / \
       9  20
         /  \
        15   7
    return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
 */
public class Binary_Trree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        int count =0;
        int sum = 1;
        while(!queue.isEmpty()){
            node = queue.poll();
            subList.add(node.val);
            --sum;
            if(node.left!=null){
                queue.offer(node.left);
                ++count;
            }
            if(node.right!=null){
                queue.offer(node.right);
                ++count;
            }
            if(sum==0){
                list.add(subList);
                subList = new ArrayList<>();
                sum = count;
                count = 0;
            }

        }
        return list;
    }
}
