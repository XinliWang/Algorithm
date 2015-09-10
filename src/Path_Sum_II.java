import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \    / \
  7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
//recursive,back-tracking,DFS
public class Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new LinkedList<>();
        pathCount(root,sum,list,sublist);
        return list;
    }
    private void pathCount(TreeNode root,int sum,List<List<Integer>> list,List<Integer> sublist){
        if (root ==null) return;
        sublist.add(root.val);
        if (root.left==null && root.right==null && sum == root.val){
            list.add(new LinkedList<Integer>(sublist));
        }else{
            pathCount(root.left,sum-root.val,list,sublist);
            pathCount(root.right,sum-root.val,list,sublist);
        }
        sublist.remove(sublist.size()-1);
    }
}
