package medium;

import java.sql.SQLOutput;

public class UglyNumberIII {
    public static void main(String[] args) {
        System.out.println(new UglyNumberIII().nthUglyNumber(4, 2, 3, 4));

    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int mid = 0, right = Integer.MAX_VALUE, left = 0, result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int count = numberUgly(mid, a, b, c);
            if (count >= n) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;

        }

        return result;
    }

    private int numberUgly(long n, long a, long b, long c) {
        return  (int) ((n / a) + (n / b) + (n / c) -
                (n / LCM(a, b)) - (n / LCM(a, c)) - (n / LCM(b, c)) +
                (n / (LCM(a, LCM(b, c)))));


    }

    public static long GDC(long a, long b) {
        if (a == 0) return b;
        return GDC(b % a, a);
    }

    public static long LCM(long a, long b) {
        return a * b / GDC(a, b);
    }

}
