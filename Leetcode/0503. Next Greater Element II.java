/*
 * BRUTE
 * TC - O(N^2)
 * SC - O(N)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                    res[i] = nums[j % n];
                    break;
                }
            }
        }

        return res;
    }
}

/*
 * OPTIMIZED
 * TC - O(2*N)
 * SC - O(N)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) {
                    res[i] = st.peek();
                } else {
                    res[i] = -1;
                }
            }

            st.push(nums[i % n]);
        }

        return res;
    }
}