import javax.swing.tree.TreeNode;
import java.util.*;
/**
 * Given n, generate all structurally unique BST's
 * (binary search trees) that store values 1...n.

 Example
 Given n = 3, your program should return all 5
 unique BST's shown below.

 1        3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 Tags Expand
 Dynamic Programming Depth First Search
 */
public class Unique_Binary_Search_Trees_II {
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

   public List<TreeNode> generateTrees(int n){
       return helper(1,n);
   }

   private ArrayList<TreeNode> helper(int left,int right){
       ArrayList<TreeNode> list = new ArrayList<>();
       if(left>right){
           list.add(null);
           return list;
       }
       for(int i=left;i<=right;i++){
           ArrayList<TreeNode> leftTree = helper(left,i-1);
           ArrayList<TreeNode> rightTree = helper(i+1,right);

           for(int j=0;j <= leftTree.size();j++){
               for(int k=0;k<=rightTree.size();k++){
                   TreeNode cur = new TreeNode(i);
                   cur.left = leftTree.get(j);
                   cur.right = rightTree.get(k);
                   list.add(cur);
               }
           }
       }
       return list;
   }
}
