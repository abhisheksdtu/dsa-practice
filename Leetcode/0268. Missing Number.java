// SPACE - O(N)
// TIME - O(N)

class Solution {
    public int missingNumber(int[] nums) {

        boolean arr[] = new boolean[nums.length + 1];

        Arrays.fill(arr, false);

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                return i;
            }
        }

        return -1;
    }
}

// SPACE - O(1)
// TIME - O(N)
// SUM VLAUE CAN BE OVERFLOWED IF NOS ARE LARGE
class Solution {
    public int missingNumber(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        long ss = ((nums.length) * (nums.length + 1)) / 2;

        return (int) (ss - sum);
    }
}

// BEST METHOD USING XOR
// SPACE - O(1)
// TIME - O(2N)
class Solution {
    public int missingNumber(int[] nums) {

        int xor = 0;

        for (int i : nums) {
            xor = xor ^ i;
        }

        int nxor = 0;

        for (int i = 1; i <= nums.length; i++) {
            nxor = nxor ^ i;
        }

        return nxor ^ xor;
    }
}

// MOST OPTIMAL
// SPACE - O(1)
// TIME - O(N)
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ (i + 1);
        }

        return xor;
    }
}