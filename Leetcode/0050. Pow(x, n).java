/*
 * BRUTE -> TLE
 * TC - O(N)
 * SC - O(1)
 */

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        boolean isPositive = (n >= 0);
        for (int i = 1; i <= Math.abs(n); i++) {
            if (isPositive)
                ans *= x;
            else
                ans /= x;
        }
        return ans;
    }
}

/*
 * RECURSION
 * TC - O(N)
 * SC - O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        double res = powHelper(x, Math.abs(nn));

        return n >= 0 ? res : 1.0 / res;
    }

    private double powHelper(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = powHelper(x, n / 2);

        return n % 2 == 0 ? half * half : half * half * x;
    }
}

/*
 * ITERATIVE OPTIMAL
 * TC - O(LOG(N))
 * SC - O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = Math.abs((long) n);

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            }

            x = x * x;
            nn = nn / 2;
        }

        return n >= 0 ? ans : 1.0 / ans;
    }
}