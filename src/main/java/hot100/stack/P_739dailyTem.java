package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_739dailyTem {
public static void main(String[] args) {
    int[] tem = {73,74,75,71,69,72,76,73};
    int[] ans = ds(tem);
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < tem.length; i++) {
        sb.append(ans[i]);
        if(i<tem.length-1) sb.append(',');
    }
    sb.append(']');
    System.out.println(sb);
}

//单调栈 栈里存下标 弹出计算
private static int[] ds(int[] tem) {
    int n = tem.length;
    int[] ans = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
   for (int i = 0; i < tem.length; i++) {
    int t = tem[i];
    while (!st.isEmpty() && t > tem[st.peek()]) {
        int j = st.peek();
        ans[j] = i - j;
        st.pop();
    }
    st.push(i);
   }
    return ans;
}
}
