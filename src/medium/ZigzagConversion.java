package medium;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] lines = new StringBuilder[numRows];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new StringBuilder();
        }

        int direcFlag = 0;
        int actualLine = 0;
        for (int i = 0; i < s.length(); i++) {
            if (actualLine == 0) direcFlag = 0;
            else if (actualLine == numRows - 1) direcFlag = 1;

            lines[actualLine].append(s.charAt(i));
            actualLine += (direcFlag == 0) ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder actual :
                lines) {
            result.append(actual.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
    }


}
