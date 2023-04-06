package medium;

public class ReverseInteger {
    public int reverse(int x) {
        int actualNumber, result = 0;

        while(x != 0){
            actualNumber = x%10;
            x /= 10;
            if(result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) return 0;
            result = result*10 + actualNumber;
        }
        return result;
    }

    public static void main(String[] args) {
        
        
    }
}
