/*
 * BRUTE
 * TC - O(N^2)
 * SC - O(1)
 */
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    c++;
                }
            }
        }

        return c;
    }
}

/*
 * OPTIMAL
 * TC - O(N*LOG(N))
 * SC - O(1)
 */
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int cnt = 0;
        int lo = 0;
        int hi = nums.size() - 1;

        while (lo < hi) {
            if (nums.get(lo) + nums.get(hi) < target) {
                cnt += (hi - lo);
                lo++;
            } else {
                hi--;
            }
        }

        return cnt;
    }
}