import java.util.ArrayList;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 Calling next() will return the next smallest number in the BST.
 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 where h is the height of the tree.
 */
public class Binary_Search_Tree_Iterator {
    ArrayList<TreeNode> list = new ArrayList<>();
    public Binary_Search_Tree_Iterator(TreeNode root){
        //左孩子最小
        while(root!=null){
            list.add(root);
            root = root.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size()>0? true : false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = list.remove(list.size()-1);
        //如果有右孩子取右孩子，没有才向上去父亲的父亲的节点
        TreeNode temp = node.right;
        while(temp!=null){
            list.add(temp);
            temp = temp.left;
        }
        return node.val;
    }
}
