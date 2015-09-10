import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].
 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals_Triangle_II {
    //使用两个数组，第一个记录前一个，第二个记录需要计算的这个，最后返回第二个
    public List<Integer> getRow(int rowIndex){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        list.add(1);
        if(rowIndex==0) return list;
        for(int i=1;i<=rowIndex;i++){
            tempList.clear();
            for(int j=0;j<=i;j++){
                if(j==0){
                    tempList.add(0,1);
                }else if(j==i){
                    tempList.add(i,1);
                }else{
                    tempList.add(j,list.get(j)+list.get(j-1));
                }
            }
            list.clear();
            list.addAll(tempList);


        }
        return list;
    }

    //每次list设为1，然后从第二个元素计算到倒数第二个，不断叠加2到n-1之间的数值
    public List<Integer> getRow2(int rowIndex){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            list.add(1);
            int prev = list.get(0);
            for(int j=1;j<i;j++){
                int cur = list.get(j);
                list.set(j,prev+cur);
                prev = cur;
            }
        }
        return list;
    }



    public static void main(String[] args){
        Pascals_Triangle_II ps = new Pascals_Triangle_II();
        List<Integer> arrayList = new ArrayList<>();
        arrayList = ps.getRow(3);
        for(int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
