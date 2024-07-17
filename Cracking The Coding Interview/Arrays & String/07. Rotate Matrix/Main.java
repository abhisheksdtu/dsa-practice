/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
*/

import java.util.Arrays;

public class Main {
    /*
     * TWO STEP PROCESS 
     * 1. TRANSPOSE THE MATRIX. CONVERT ROWS INTO COLS AND VICE VERSA
     * 2. REVERSE EACH ROW
     * TC - O(N^2)
     * SC - O(1)
     */
    public static void brute(int matrix[][]) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(matrix));
        brute(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}