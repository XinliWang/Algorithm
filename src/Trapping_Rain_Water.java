/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
        if(height==null || height.length<=2){
            return 0;
        }
        int size = height.length;
        int maxHeight = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=0;i<size;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int volume = 0;
        int leftMax = height[0];
        for(int i=0;i<maxIndex;i++){
            if(leftMax > height[i]){
                volume += leftMax - height[i];
            }else{
                leftMax = height[i];
            }
        }
        //we can use the same rule from the last element to the max one
        int rightMax = height[size-1];
        for(int i=size-2;i>maxIndex;i--){
            if(rightMax>height[i]){
                volume += rightMax - height[i];
            }else{
                rightMax = height[i];
            }
        }
        return volume;
    }
}
