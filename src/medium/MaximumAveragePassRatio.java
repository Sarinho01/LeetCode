package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        int[][] asd = {{3, 5}, {1, 2}, {2, 2}};
        MaximumAveragePassRatio maximumAveragePassRatio = new MaximumAveragePassRatio();
        System.out.println(maximumAveragePassRatio.maxAverageRatio(asd, 2));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> classesQueue = new PriorityQueue<>((x,y) -> Double.compare(y[0], x[0]));
        for (int[] values:classes) {
            classesQueue.add(new double[]{actualValue(values[0], values[1]), values[0], values[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] actualClass = classesQueue.poll();
            actualClass[1]++;
            actualClass[2]++;
            classesQueue.add(new double[]{actualValue(actualClass[1], actualClass[2]), actualClass[1], actualClass[2]});
        }
        double sum = 0;
        for (double[] values :classesQueue) {
            sum += values[1]/values[2];
        }
        return sum / classes.length;
    }
    private static double actualValue(double x, double y) {
        return (x+1)/ (y+1) - x/y;

    }




}
