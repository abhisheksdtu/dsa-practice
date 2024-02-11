/*
 * BRUTE
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

/*
 * OPTIMAL
 * TC - O(N)
 * SC - O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0;

        for (int num : nums) {
            if (cnt == 0) {
                el = num;
                cnt++;
            } else if (num == el) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for (int num : nums) {
            if (num == el) {
                cnt1++;
            }
        }

        if (cnt1 > nums.length / 2) {
            return el;
        }

        return -1;
    }
}