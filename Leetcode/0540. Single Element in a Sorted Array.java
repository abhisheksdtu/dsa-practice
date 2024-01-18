/*
 * BRUTE -> XOR 
 * N XOR N = 0
 * 0 XOR N = N
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}