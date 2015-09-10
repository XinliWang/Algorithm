import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        if(numRows==0) return list;
        subList.add(1);
        list.add(subList);
        for(int i=1;i<numRows;i++){
            subList = new ArrayList<Integer>();
            for(int j = 0;j<=i;j++){
                if(j==0){
                    subList.add(0, 1);
                }
                else if(j==i){
                    subList.add(i,1);
                }
                else{
                    subList.add(j,list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }

            }
            list.add(subList);
        }
        return list;
    }
    public static void main(String[] args){
        Pascals_Triangle p = new Pascals_Triangle();
        p.generate(5);
    }
}
