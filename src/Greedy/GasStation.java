package Greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
         if(gas == null || cost == null || gas.length <= 0 
            || cost.length <= 0 || gas.length != cost.length) return -1;
         int curSum = 0;
         int total = 0;
         int rightStaPoint = 0; // init value;
         for(int i = 0; i < gas.length; i++) {
             curSum += gas[i] - cost[i];
             total += gas[i] - cost[i];
             if (curSum < 0) { // no gas storage change start point
                 rightStaPoint = i + 1;
                 curSum = 0;
             }
         }
         if (total < 0) return -1;
         return rightStaPoint;
    }
}
