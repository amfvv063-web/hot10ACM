package hot100.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P15_threeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = ThreeSum(nums);
        StringBuffer sb = new StringBuffer();
        for (List<Integer> list : ans) {
            sb.append(list.toString()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static List<List<Integer>> ThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            if (x > 0) {
                break;
            }
            int target = -x;
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            for (int j = i + 1; j < nums.length; j++) {
                
                int k = nums[j];
                if (j> i + 1 && k == nums[j-1]) {
                    continue;
                }
                int y = target - k;
                if (map.containsKey(y)) {
                    res.add(x);
                    res.add(map.get(y));
                    res.add(k);
                    ans.add(new ArrayList<>(res));
                    res.clear();
                } else {
                    map.put(k, k);
                }
            }
        }
        return ans;
    }

}
