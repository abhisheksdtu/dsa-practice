/*
 * BRUTE
 * TC - O(N^2)
 * SC - O(1)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}

/*
 * OPTIMAL USE NEXT GREATER ELEMENT LOGIC
 * INSTEAD OF STORING NUMBER STORE INDICES
 * TC - O(N)
 * SC - O(N)
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            }

            st.push(i);
        }

        return res;
    }
}