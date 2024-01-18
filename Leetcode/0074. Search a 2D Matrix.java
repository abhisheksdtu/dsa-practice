/*
 * BRUTE
 * APPROACH -> TRAVERSE & CHECK ALL ELEMENTS OF THE MATRIX
 * TC - O(N*M)
 * SC - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
 * BETTER
 * APPROACH -> SINCE EACH ROW IS SORTED. PERFORM BINARY SEARCH ON EACH ROW
 * TC - O(N*log(M))
 * SC - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int lo = 0;
            int hi = m - 1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return false;
    }
}

/*
 * BINARY SEARCH BETTER
 * APPROACH
 * 1. SINCE EACH ROW IS SORTED.
 * 2. PERFORM BINARY SEARCH ON ROW IF TARGET EXISTS B/W FIRST & LAST ELEMENT OF
 * ROW
 * TC - O(N + log(M))
 * SC - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int lo = 0;
            int hi = m - 1;

            if (target >= matrix[i][lo] && target <= matrix[i][hi]) {
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}

/*
 * BINARY SEARCH OPTIMAL
 * APPROACH
 * 1. SINCE EACH ROW IS SORTED.
 * 2. THE FIRST NUMBER OF EACH ROW IS GREATER THAN THE LAST NUMBER OF PREVIOUS
 * ROW
 * 3. WE'LL TAKE ALL THE ROWS AND COMBINE THEM TO MAKE AN IMAGINARY SINGLE ARRAY
 * 4. NOW WE'LL PERFORM BINARY SEARCH OVER IT
 * 5. LO = 0, HI = N * M - 1, MID = (LO + HI) / 2
 * 6. ROW INDEX = MID / (NO. OF COLS)
 * 7. COL INDEX = MID % (NO. OF COLS)
 * TC - O(log(N*M))
 * SC - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = n * m - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int r = mid / m;
            int c = mid % m;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }
}
