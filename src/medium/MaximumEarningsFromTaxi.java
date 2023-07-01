package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumEarningsFromTaxi {
    public static void main(String[] args) {
        MaximumEarningsFromTaxi maximumEarningsFromTaxi = new MaximumEarningsFromTaxi();
        int[][] rides = {{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        System.out.println(maximumEarningsFromTaxi.maxTaxiEarnings(20,    rides));


    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(x -> x[1]));
        long[] maxPValues = new long[n];
        long maxValue = 0;
        int currentP = 0;

        for (int[] actualArray :rides) {
            for (int i = currentP; i < actualArray[1]; i++) {
                maxPValues[i] = maxValue;
            }
            currentP = actualArray[1];

            long currentValue = maxPValues[actualArray[0]] + (actualArray[1] - actualArray[0] + actualArray[2]);
            if(currentValue > maxValue){
                maxValue = currentValue;
            }
        }
        return maxValue;

    }

}
