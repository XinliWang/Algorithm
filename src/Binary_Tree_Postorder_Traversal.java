import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
    1
     \
      2
     /
    3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Postorder_Traversal {
    /**
     * Soluiton1:
     * 1. postorder traversal's order is left->right->father
     * 2. each time we insert node to the first position of the list
     * 3. each time we push node to stack's order is root->(left->right)
     * 4. each time we pop node from stack is root->(right->left)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node!=null){
                list.add(0, node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return list;
    }

    /**
     * Solution2: backtracking
     * 1. Using Stack and HashSet
     * 2. traverse to the leftmost node，then to the right node. Although we pop the parent node in
     *    order to get its right node, we need to push parent node again to the stack.
     * 3. each time the node which we traverse should be added to HashSet
     * 4. if the right node has left part and HashSet doesn't have,then traverse  and to the leftmost node
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null && !set.contains(cur)){
                stack.push(cur);
                set.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            while(cur.right==null || set.contains(cur.right)){
                list.add(cur.val);
                set.add(cur);
                if (stack.isEmpty()){
                    return list;
                }
                cur = stack.pop();
            }
            stack.push(cur);
            cur = cur.right;
        }
        return list;
    }

    /**
     * Solution3:recursive
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderOperation(root,list);
        return list;
    }

    private void postorderOperation(TreeNode node,List<Integer> list){
        if(node!=null){
            postorderOperation(node.left,list);
            postorderOperation(node.right,list);
            list.add(node.val);
        }

    }
}
