class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] nger = nextGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nger.length; i++) {
            map.put(nums2[i], nger[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > st.peek()) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek();
            } else {
                res[i] = -1;
            }

            st.push(arr[i]);
        }

        return res;
    }
}