/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
 since a node can be a descendant of itself according to the LCA definition.
 */

/**
 * 1.if p and q distribute in both side, then r is common ancestor node
 * 2.if p and q in left part, then use r.left to test
 * 3.if p and q in right part,then use r.right to test
 */


public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    /**
     * Solution1: Iterative
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val)return q;
        TreeNode r = root;
        while(r!=null){
            if ((r.val-p.val)*(r.val-q.val)<=0) return r;
            if(r.val>p.val){
                r = r.left;
            }else{
                r = r.right;
            }
        }
        return r;
    }

    /**
     * Solution2: Recursive
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor2(root.left,p,q);
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor2(root.right,p,q);
        return root;
    }

}
