package hot100.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class P_347topKFrequent {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] ans = topKFrent(nums, k);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
            if (i < ans.length - 1)
                sb.append(',');
        }
        sb.append("]");
        System.out.println(sb);
    }

    // 重复元素 + 桶排序
    private static int[] topKFrent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        // 重复元素统计
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
        }
        int maxCnt = Collections.max(map.values());

        // 取最大值+1作为桶排序的最大容量  下标为元素重复数量， value为元素， 倒着遍历取值
        List<Integer>[] buckets = new List[maxCnt + 1];
        Arrays.setAll(buckets, i -> new ArrayList<Integer>());
        for (Entry<Integer, Integer> e : map.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }
        int j = 0;
        for (int i = maxCnt; j < k; i--) {
            for (Integer x : buckets[i]) {
                ans[j++] = x;
            }
        }
        return ans;
    }

}
