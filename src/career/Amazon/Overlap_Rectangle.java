package career.Amazon;

/**
 * Created by wangxinli on 12/6/15.
 */
public class Overlap_Rectangle {
   /*   Solution1:

    public static boolean overlap(Retangle first, Retangle second) {
        if (first == null || second == null) {
            return false;
        }
        int bottomRightX = Math.min(first.bottomRight.x, second.bottomRight.x);
        int bottomRightY = Math.max(first.bottomRight.y, second.bottomRight.y);
        int topLeftX = Math.max(first.topLeft.x, second.topLeft.x);
        int topLeftY = Math.min(first.topLeft.y, second.topLeft.y);
        if (topLeftX < bottomRightX && bottomRightY < topLeftY) {
            return true;
        }
        return false;
    }
    */

    /*
        Solution2:
        public static boolean overlap(Retangle first, Retangle second) {
        if (first == null || second == null) {
            return false;
        }
            int A = first.topLeft.x;
            int B = first.topLeft.y;
            int C = first.bottomRight.x;
            int D = first.bottomRight.y;

            int E = second.topLeft.x;
            int F = second.topLeft.y;
            int G = second.bottomRight.x;
            int H = second.bottomRight.y;
            if(C <= E || G <= A || D >= F || H >= B){
                    return false;
            }
            return true;
            }
     */

}
