/*
 * BRUTE
 * APPROACH -> USE 3 LOOPS
 * FIRST -> i -> 0 to n-1
 * SECOND -> j -> i+1 to n-1
 * THIRD -> k -> j+1 to n-1
 * TC - O(N^3 log(M)) -> LOG(M) TIME FOR INSERTING TRIPLETS INTO SET 
 * M - NUMBER OF TRIPLETS
 * SC - O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        res.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}