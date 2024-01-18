/*
 * BRUTE
 * 1. LOOP i -> [0 -> N)
 * 2. LOOP j -> [i -> N)
 * 3. OUR SUB ARRAY WILL BE FROM [i -> j]
 * 4. LOOP FROM i to j AND FIND THE SUM OF THE SUB ARRAY WHILE MAINTAINING MAX
 * 
 * TC - O(N^3)
 * SC - O(1)
 */
class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}

/*
 * BETTER
 * 
 * TC - O(N^2)
 * SC - O(1)
 */
class Solution {
    public int maxSubArray(int[] arr) {

        int n = arr.length;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}

/*
 * OPTIMAL
 * 
 * TC - O(N^2)
 * SC - O(1)
 */
class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;

        int sum = arr[0];

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + arr[i], arr[i]);

            max = Math.max(sum, max);
        }

        return max;
    }
}