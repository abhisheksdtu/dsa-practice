/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
Hints: #34, #88, # 7 04 
*/

import java.util.Arrays;

public class Main {
    /*
     * TC - O(M * N)
     * SC - O(N)
     */
    public static void brute(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][] { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 0, 1, 0 } };
        System.out.println(Arrays.deepToString(matrix));
        brute(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}