class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> st = new Stack<>();

        while (s.size() > 0) {
            int ele = s.pop();

            while (!st.isEmpty() && st.peek() > ele) {
                s.push(st.pop());
            }
            st.push(ele);
        }

        return st;
    }
}