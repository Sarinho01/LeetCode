package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> listParenthesis = new ArrayList<>();
        writeParenthesis(listParenthesis, n, 0, new StringBuilder());
        return listParenthesis;
    }

    private void writeParenthesis(List<String> listParenthesis, int openNumber, int closeNumber, StringBuilder stringBuilder) {
        if(openNumber > 0 && closeNumber > 0){
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());

            stringBuilder.append('(');
            writeParenthesis(listParenthesis, openNumber-1, closeNumber+1, stringBuilder);

            stringBuilder2.append(')');
            writeParenthesis(listParenthesis, openNumber, closeNumber-1, stringBuilder2);


        } else if (openNumber > 0) {
            stringBuilder.append('(');
            writeParenthesis(listParenthesis, openNumber-1, closeNumber+1, stringBuilder);
        }
        else if (closeNumber > 0){
            stringBuilder.append(')');
            writeParenthesis(listParenthesis, openNumber, closeNumber-1, stringBuilder);
        }
        else {
            listParenthesis.add(stringBuilder.toString());
        }

    }
}
