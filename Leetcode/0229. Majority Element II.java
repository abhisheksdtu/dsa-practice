/*
 * BRUTE
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}

/*
 * OPTIMAL
 * TC - O(N)
 * SC - O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int c1 = 0, c2 = 0, e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (c1 == 0 && num != e2) {
                c1++;
                e1 = num;
            } else if (c2 == 0 && num != e1) {
                c2++;
                e2 = num;
            } else if (e1 == num) {
                c1++;
            } else if (e2 == num) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (e1 == num) {
                c1++;
            } else if (e2 == num) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            res.add(e1);
        }

        if (c2 > nums.length / 3) {
            res.add(e2);
        }

        return res;
    }
}