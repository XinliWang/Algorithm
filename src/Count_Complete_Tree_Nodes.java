/**
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.
 */


/*
方法：1.get the height of leftest part
     2.get the height of rightest part
     3.if both height are equal,then the number of nodes is 2^height -1
     4.if they are not equal, then recursively add the number of left and right subtree
 */
public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root){
        if(root==null)return 0;
        int heightLeft = getLeftMaxHeight(root);
        int heightRight = getRightMaxHeight(root);
        if(heightLeft==heightRight) return (2<<(heightLeft-1))-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private int getLeftMaxHeight(TreeNode node){
        int height=0;
        while(node!=null){
            node = node.left;
            height++;
        }
        return height;

    }
    private int getRightMaxHeight(TreeNode node){
        int height=0;
        while(node!=null){
            node = node.right;
            height++;
        }
        return height;
    }


}
