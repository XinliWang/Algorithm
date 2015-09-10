/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 大意就是：取两条垂线与x轴组成一个水桶（无视其他点），以短的一边为桶高，求面积
 */
public class Container_With_Most_Water {
    public int maxArea(int[] height){
        int size = height.length;
        int maxNum = 0;
        int i = 1;
        int j = size;
        int high =0;
        while(i<j){
            high = height[i-1]>height[j-1]? height[j-1] : height[i-1];
            maxNum = Math.max(maxNum,high * (j-i));
            if(height[i-1]>height[j-1])j--;
            else i++;
        }
        return maxNum;


    }
}
