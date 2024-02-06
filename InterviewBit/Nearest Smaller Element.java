public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer nums : list) {
            while (stack.size() > 0 && stack.peek() >= nums) {
                stack.pop();
            }
            if (stack.size() > 0) {
                res.add(stack.peek());
            } else {
                res.add(-1);
            }
            stack.push(nums);
        }

        return res;
    }
}
