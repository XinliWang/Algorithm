import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
    1            <---
  /   \
 2     3         <---
  \     \
   5     4       <---
 You should return [1, 3, 4].
 */
public class Binary_Tree_Right_Side_View {

     //Solution1:BFS: each level we add the last element
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         if (root==null) return list;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(queue.size()!=0){
             int count = queue.size();
             while(count!=0){
                 TreeNode node = queue.poll();
                 --count;
                 if (count==0){
                     list.add(node.val);
                 }
                 if (node.left!=null){
                     queue.add(node.left);
                 }
                 if (node.right!=null){
                     queue.add(node.right);
                 }
             }
         }
         return list;
     }


    /**
     * Solution2: DFS: recursive
     * 1. each level only add one element
     * 2. each time first check the right node,then the left node
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsMethod(root,1,list);
        return list;
    }

    public static void dfsMethod(TreeNode node,int depth,List<Integer> list){
        if (node==null)return;
        if (list.size()<depth){
            list.add(node.val);
        }
        dfsMethod(node.right,depth+1,list);
        dfsMethod(node.left,depth+1,list);
    }




}
