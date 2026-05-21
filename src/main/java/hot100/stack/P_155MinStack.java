package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_155MinStack {
    private static final Deque<int[]> st = new ArrayDeque<>();
    // 因为存在preMin 所以要维护两个变量 val, minVal
    public P_155MinStack(){
        st.push(new int[] {0, Integer.MAX_VALUE});
    }

    public void push(int val){
        st.push(new int[] {val, Math.min(val, getMin())});
    }

    public void pop(){
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }

    public static void main(String[] args) {
        P_155MinStack stack = new P_155MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        int ans1 = stack.getMin();
        stack.pop();
        int ans2 = stack.top();
        stack.pop();
        int ans3 = stack.getMin();
        System.out.printf("%d %d %d%n" ,ans1, ans2,ans3);
    }
}
