import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * My Submissions Question Solution
   Given a binary tree, check whether it is a mirror of itself
   (ie, symmetric around its center).
   For example, this binary tree is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3
 But the following is not:
         1
        / \
       2   2
        \   \
        3    3

 */
public class Symmetric_Tree {
    /**
     * Solution1:iterative way, use BFS , 3ms
     * 1.At first store nodes of one level into queue
     * 2.poll out of queue, and store its left and right node into queue and list
     * 3.compare head and tail node of list
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            for (int i = 0, j = size - 1; i <= j; i++, j--) {
                if (list.get(i) == null && list.get(j) == null) {
                    continue;
                }
                if (list.get(i) == null || list.get(j) == null || list.get(i).val != list.get(j).val) return false;
            }
        }
        return true;
    }

    /**
     * Solution2:recursive way, use DFS , 2ms
     * 1. get the list of left side tree
     * 2. get the list of right side tree
     * 3. compare each element.
     * Notification: we need save null node into list in order to compare the case
     * which one node of side is null and one node of another side is some value.
     */
    public boolean isSymmetric2(TreeNode root) {
            ArrayList<Integer> listLeft = new ArrayList<>();
             ArrayList<Integer> listRight = new ArrayList<>();
             helperLeft(root.left,listLeft);
             helperRight(root.right,listRight);
             int sizeLeft = listLeft.size();
             int sizeRight = listRight.size();
             if(sizeLeft!=sizeRight)return false;
             for(int i=0;i<sizeLeft;i++){
                 if(listLeft.get(i)!=listRight.get(i))return false;
             }
             return true;
    }
    private void helperLeft(TreeNode node,ArrayList<Integer> listLeft){
        if(node==null){
            listLeft.add(null);
            return;
        }
        listLeft.add(node.val);
        helperLeft(node.left,listLeft);
        helperLeft(node.right,listLeft);
    }
    private void helperRight(TreeNode node,ArrayList<Integer> listRight){
        if(node==null){
            listRight.add(null);
            return;
        }
        listRight.add(node.val);
        helperRight(node.right,listRight);
        helperRight(node.left,listRight);
    }


    /**
     * Solution3: Recursive, DFS, 1ms
     */
    public boolean isSymmetric3(TreeNode root) {
        if(root==null)return true;
        return compareNode(root.left,root.right);
    }

    private boolean compareNode(TreeNode first, TreeNode second){
        if(first==null && second==null)return true;
        //one node of side is null, another side is not. it's false
        if(first==null || second==null)return false;
        //compare value and continue the next loop.
        return (first.val==second.val)&&compareNode(first.left,second.right) && compareNode(first.right,second.left);
    }
}
