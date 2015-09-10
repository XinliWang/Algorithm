import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

        1
       / \
      2   5
     / \   \
    3   4   6
 The flattened tree should look like:
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
 click to show hints.

 Hints:
 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class Flatten_Binary_Tree_to_Linked_List {
    /**
     * Solution1:
     * 1. Using Stack implement similar to pre-order traversal
     * 2. each time push right node frist and then left node
     * 3. each time pop one node to judge
     */
    public void flatten(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if(root.right!=null)stack.push(root.right);
        if(root.left!=null)stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
            cur.right = node;
            cur.left = null;
            cur = node;
        }
    }

    /**
     * Solution2: recursive
     * 1.each time we add left node to the root, then the right
     * 2.we need a global node to record the rightmost node
     * 3.Because when we make a left or right node to the rightmost node,
     *   we need to change this right node of node.
     */
    private TreeNode lastNode = null;
    public void flatten2(TreeNode root){
        if(root==null)return;
        if(lastNode!=null){
            lastNode.right = root;
            lastNode.left = null;
        }
        lastNode = root;
        //we need to save this right node, after flatten2(root.left),the root's right will change.
        TreeNode right = root.right;
        flatten2(root.left);
        flatten2(right);
    }





}
