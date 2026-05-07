
package hot100.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P128_longestConsecutive {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    int []nums = new int[0];
                }
                line = line.substring(1, line.length()-1);
                String[] part = line.split(",");
                int[] nums = new int[part.length];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(part[i]);
                }
                int ans = lonngestConsecutive(nums);
                System.out.println(ans);
            }

            private static int lonngestConsecutive(int[] nums) {
                Set<Integer> set = new HashSet<>();
                int ans = 1;
                for (int num : nums) {
                    set.add(num);
                }
                //先set去重
                for (Integer s : set) {
                    if (set.contains(s-1)) {
                        continue;
                    }
                    //找起始点
                    int y = s + 1;
                    int cnt = 1;
                    while (set.contains(y)) {
                        cnt++;
                        y++;
                    }
                    ans = Math.max(cnt, ans);
                }
                return ans;

            }
    
}