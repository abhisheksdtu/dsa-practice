/*
 * BRUTE
 * MAINTAIN A FREQUENCY MAP & THEN ITERATE OVER MAP TO CHECK WHICH ELEMENT APPEARS ONCE
 * 
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

/*
 * OPTIMAL
 * XOR METHOD
 * 
 * TC - O(N)
 * SC - O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor;
    }
}