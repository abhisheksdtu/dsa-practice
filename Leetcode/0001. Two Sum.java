class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];

            if (map.containsKey(numberToFind)) {
                return new int[] { map.get(numberToFind), i };
            }

            map.put(nums[i], i);
        }

        return null;
    }

}