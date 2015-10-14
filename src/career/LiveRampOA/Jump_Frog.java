package career.LiveRampOA;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题意：
 * 1.一只青蛙过河，从起始位置position 0，一路跳到X, 每次最远距离为D
 * 2.每秒落下一片叶子，青蛙可以落在上面，叶子不会消失
 * 3.给了一个数组Array, Array[k]表示k秒落下的叶子的position
 * 4.求最早可以跳过X的时刻，如果没有叶子或只落下一片叶子就能跳过去，就返回0，不能达到返回-1
 * 5.for example:
 * X=7, D=3 , Array = {5,1,3,2,6}
 * 起始位置可以到达的位置1，2，3
 * 0秒，叶子落到5， 可以到达的位置没变化
 * 1秒，叶子落到1，可以到达的位置为1，2，3，4
 * 2秒，叶子落到3，可以到达的位置为1，2，3，4，5，6，7，8（此时青蛙能跳到叶子5）
 * 可以跳过7，返回当前秒数
 */
public class Jump_Frog {
    /**
     * Solution1:
     * 1.In general, we use dynamic programming solution to figure out this question. Using an array to record the earliest time of each position from 0 to X.
     *  The last element of this array is the result. If the value of this element is maximum,it means we cannot get there. if not, return it value.
     * 2.At first, we need consider some edge case. if there is no leaf or frog could jump to the other side of pond without leaf, we should return 0;
     * 3.If there are more than one leaf falling into the same position, we only need record the earliest time.
     * 4.Every leaf can change the whole situation.  If there are some leafs falling, but frog cannot get there,it doesn't change anything. And now the leaf falls to the
     *
     *
     *
     *
     * 1.每下落一个叶子，遍历一遍所有下落的叶子，记录所能到达的位置
     * 2.直到到达X
     */
    public static int frogJump(int[] arr,int X,int D){
        if(arr==null || arr.length==0 || X<=D)return 0;
        //DP is the earliest time to get each position
        int[] DP = new int[X+1];
        Arrays.fill(DP,Integer.MAX_VALUE);
        DP[0] = 0;
        //save leaf information, remove the duplicated leaf
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(X,0);
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                //save the earliest leaf information
                map.put(arr[i],i);
            }
        }

        for(int j=1;j<=X;j++){
            //j is the position of leaf
            if(map.containsKey(j)){
                if(j<=D){
                    DP[j] = map.get(j);
                }else{
                    //get the earliest time of range of fallen leaf
                    for(int s=1;s<=D;s++){
                        //before the leaf falls at the position j
                        if(map.get(j)<DP[j-s]){
                            DP[j] = Math.min(DP[j],DP[j-s]);
                        }else{
                        //when or after leaf falls
                            DP[j] = Math.min(DP[j],map.get(j));
                        }
                    }

                }
            }
        }
        return DP[X]==Integer.MAX_VALUE? -1:DP[X];
    }

    public static void main(String[]args){
        int[] a = {5,1,3,2,6};
        System.out.print(frogJump(a,7,3));
    }





    }

    /**
     * Solution2:并查集
     * 1.每个叶子落下，插入已排好序的叶子中
     * 2.记录叶子能够伸展的范围
     * 3.如果叶子的伸展范围到达了另一片叶子，则合并这两片叶子的范围
     * 4.直到范围能全部覆盖并到达X
     *
     */


    /**
     * Solution3:使用Maximum gap
     */



