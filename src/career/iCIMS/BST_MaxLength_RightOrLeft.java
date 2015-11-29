package career.iCIMS;
import java.util.*;
/**
 * http://stackoverflow.com/questions/18299738/maximum-length-of-a-descending-path-in-a-tree-which-always-goes-leftright
 */

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

public class BST_MaxLength_RightOrLeft {
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

        public int solution(Tree T) {
            // write your code in Java SE 8
            List<Tree> list = new ArrayList<Tree>(10000);

            if (T == null)
                return 0;
            int maxLength = 0;
            //we store the length into node
            T.x = 0;
            list.add(T);

            while (list.size() != 0)
            {
                Tree curNode = list.get(list.size()-1);
                list.remove(list.size()-1);
                int reminder = curNode.x % 100000;
                if (curNode.l != null)
                {
                    /**
                     * if the value of node is i(small number), then left is i+1, right is 100000
                     * if the value of node is i(large number), then left is 1, right is i*2
                     * each time we need compare maxLength and left or right length
                     * Therefore, we can compare left side directly, and compare with right side via dividing 10000
                     */
                    curNode.l.x = 1 + reminder;
                    maxLength = Math.max(maxLength, curNode.l.x);
                    list.add(curNode.l);
                }
                if (curNode.r != null)
                {
                    curNode.r.x = 100000 + (curNode.x - reminder);
                    maxLength = Math.max(maxLength, curNode.r.x / 100000);
                    list.add(curNode.r);
                }
            }
            return maxLength;
        }
    }