/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */

//使用二分法查找
public class Sqrt {
    public int mySqrt(int x){
        int low = 1;
        int high = x;
        int result=0;
        while(low<=high){
            int mid = low + (high-low)/2;
            //protect form
            if(mid<=x/mid){
                low = mid+1;
                result = mid;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
}
