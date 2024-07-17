/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0. 
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

        int row[] = new int[m];
        int col[] = new int[n];

        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (col[j] == 0) {
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