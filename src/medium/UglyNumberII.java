package medium;

import java.util.PriorityQueue;

public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
       int[] numbers = new int[n];
        int two = 0, three = 0, five = 0;
        int m2, m3, m5, minN;
        numbers[0] = 1;

        for (int i = 1; i < n; i++) {
            m2 = numbers[two] * 2;
            m3 = numbers[three] * 3;
            m5 = numbers[five] * 5;
            minN = Math.min(m2,Math.min(m3,m5));
            if(m2 == minN){
                numbers[i] = m2;
                two++;
            }
            if(m3 == minN){
                numbers[i] = m3;
                three++;
            }
            if(m5 == minN){
                numbers[i] = m5;
                five++;
            }
        }


       return numbers[n-1];
    }
}
