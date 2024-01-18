class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;

        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            max = Math.max(cnt, max);
        }

        return max;
    }
}