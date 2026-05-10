package hot100.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P239_maxSlidingWindow {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    line = line.substring(1, line.length()-1);
    String[] paStrings = line.split(",");
    int k = sc.nextInt();
    int[] nums = new int[paStrings.length];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(paStrings[i]);
    }
    int[] ans = maxSlidWindow(nums, k);
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int x : ans) {
        sb.append(x);
        sb.append(',');
    }
    sb.append(']');
    System.out.println(sb);
}

// 双向队列  两个退栈规则
// 1. 单调栈， 维护单调递减顺序
// 2. 过期策略，左边下标和滑窗左边下标对比， 小于就左边退栈
private static int[] maxSlidWindow(int[] nums, int k) {
   int n = nums.length;
   int[] ans = new int[n - k + 1];
   Deque<Integer> q = new ArrayDeque<>();
   for (int i = 0; i < n; i++) {
    while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
        q.removeLast();
    }
    q.add(i);
    int l = i - k + 1;
    // k = r-l+1  r - k +1
    if (q.getFirst()< l) {
        q.removeFirst();
    }
    if (l >= 0) {
        ans[l] = nums[q.getFirst()];
    }
   }
   return ans;
   }
}
