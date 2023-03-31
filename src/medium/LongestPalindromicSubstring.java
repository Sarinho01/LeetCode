package medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        for (int i = s.length(); i > 0 ; i--) {
            int initialP = 0;
            int finalP = i;
            while(finalP <= s.length()){
                String actualW = s.substring(initialP, finalP);
                if(isPalindrome(actualW)) return actualW;
                initialP++;
                finalP++;
            }
        }

        return null;
    }

    private static boolean isPalindrome(String actualStr) {
        int strLength = actualStr.length();
        if (strLength == 1) return true;

        int pointRight, pointLeft, forLength;
        if (strLength % 2 == 0) {
            pointRight = strLength / 2;
            pointLeft = pointRight - 1;
            forLength = pointRight;
        } else {
            pointRight = (strLength / 2) + 1;
            pointLeft = pointRight - 2;
            forLength = pointRight - 1;
        }

        for (int i = 0; i < forLength; i++) {
            if (!(actualStr.charAt(pointLeft) == actualStr.charAt(pointRight))) return false;
            pointLeft--;
            pointRight++;
        }
        return true;
    }
}
