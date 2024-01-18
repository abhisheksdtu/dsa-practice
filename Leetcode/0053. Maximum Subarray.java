/*
 * BRUTE
 * TC - O(N^3)
 * SC - O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}