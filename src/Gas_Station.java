/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class Gas_Station {
    /**
     * 1. each time we calculate the difference of gas and cost
     * 2. if total>=0，there is at least one possibility we can do it
     * 3. if past + cur = total>=0, past<0 => cur>=0 . So if cur<0, we make position is i+1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int position = 0;
        for(int i=0; i<gas.length;i++){
            int diff = gas[i] - cost[i];
            cur += diff;
            total += diff;
            if(cur<0){
                cur = 0;
                position = i+1;
            }
        }
        if(total>=0) return position;
        return -1;
    }
}
