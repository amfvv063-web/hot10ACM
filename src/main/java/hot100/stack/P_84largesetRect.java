package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_84largesetRect {
public static void main(String[] args) {
    int[] height = {2,1,5,6,2,3};
    int ans = lRt(height);
    System.out.println(ans);
}

//找左右边界 当前i的左右第一个更小的
private static int lRt(int[] height) {
        int n = height.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        //找不到边界就是-1， n 说明左边界/右边界全满足
        for (int i = 0; i < n; i++) {
            int x = height[i];
            while (!st.isEmpty() && height[st.peek()] >= x) {
                st.pop();
            }
            left[i] =st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        st.clear();

        
        for (int r = height.length - 1; r >= 0; r--) {
            int x = height[r];
            while (!st.isEmpty() && height[st.peek()]  >= x) {
                st.pop();
            }
            right[r] = st.isEmpty()? n: st.peek();
            st.push(r);
        }

      for (int i = 0; i < height.length; i++) {
        ans = Math.max(ans, height[i] * (right[i] - left[i] - 1));
      }
      return ans;

}
}
