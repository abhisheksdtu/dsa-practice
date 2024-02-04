/*
 * USING ARRAYS
 */
class MyStack {
    int[] arr;
    int top;
    int size = 5;

    public MyStack() {
        arr = new int[size];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int x) {
        if (arr.length == size()) {
            int[] narr = new int[size() * 2];
            for (int i = 0; i < size(); i++) {
                narr[i] = arr[i];
            }
            arr = narr;
            push(x);
            return;
        }
        top++;
        arr[top] = x;
    }

    public int pop() {
        if (size() == 0) {
            return -1;
        }
        return arr[top--];
    }

    public int top() {
        if (size() == 0) {
            return -1;
        }
        return arr[top];
    }

    public boolean empty() {
        return size() == 0;
    }
}

/*
 * USING TWO QUEUES
 */

class MyStack {
    Queue<Integer> mQ;
    Queue<Integer> hQ;

    public MyStack() {
        mQ = new ArrayDeque<>();
        hQ = new ArrayDeque<>();
    }

    public void push(int x) {
        mQ.add(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        while (mQ.size() > 1) {
            hQ.add(mQ.remove());
        }

        int ele = mQ.remove();

        Queue<Integer> tQ = mQ;
        mQ = hQ;
        hQ = tQ;

        return ele;
    }

    public int top() {
        if (empty()) {
            return -1;
        }

        while (mQ.size() > 1) {
            hQ.add(mQ.remove());
        }

        int ele = mQ.remove();

        Queue<Integer> tQ = mQ;
        mQ = hQ;
        hQ = tQ;
        mQ.add(ele);

        return ele;
    }

    public boolean empty() {
        return mQ.size() == 0;
    }

}

/*
 * USING SINGLE QUEUE
 */

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}