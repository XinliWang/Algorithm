/**
 * Given a binary tree containing digits from 0-9 only,
 * each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */

/**
 * Solution:DFS and recursive
 * 1. Defining a global variable to count sum of numbers
 * 2. each time we need to judge if the node is leaf.
 * 3. If yes, add this number. If no, num = 10*num + node.val
 */

public class Sum_Root_to_Leaf_Numbers {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        dfsMethod(root,0);
        return result;
    }
    public void dfsMethod(TreeNode node,int num){
        if(node==null)return;
        num = 10*num + node.val;
        if(node.left==null && node.right==null){
            result += num;
        }else{
            dfsMethod(node.left,num);
            dfsMethod(node.right,num);
        }

    }
}
