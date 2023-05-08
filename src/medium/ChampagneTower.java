package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTower(100000009, 33, 17));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] champagnes = new double[query_row + 1][query_row + 1];
        double over;
        champagnes[0][0] = poured;
        for (int i = 0; i < champagnes.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (champagnes[i][j] > 1) {
                    over = champagnes[i][j] - 1;
                    champagnes[i][j] = 1;
                    if (query_row != i) {
                        champagnes[i + 1][j] += over/2;
                        champagnes[i + 1][j + 1] += over/2;
                    }
                }
                over = 0;
            }
        }


        return champagnes[query_row][query_glass];
    }


}
