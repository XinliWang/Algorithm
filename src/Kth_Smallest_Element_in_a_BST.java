import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?

 Hint:

 Try to utilize the property of a BST.
 What if you could modify the BST node's structure?
 The optimal runtime complexity is O(height of BST).
 */

//使用中序遍历inorder traversal
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){
            if(k!=0){
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                result = node.val;
                node = node.right;
                --k;
            }else{
                break;
            }
        }
        return result;
    }
}
