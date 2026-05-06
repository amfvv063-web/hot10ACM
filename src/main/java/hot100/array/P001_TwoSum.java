package hot100.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * LeetCode 1. Two Sum — ACM 自订题面（本地练习用）
 *
 * <p>原题：https://leetcode.cn/problems/two-sum/
 *
 * <p>输入格式：
 * <ul>
 *   <li>第 1 行：整数 n，表示数组长度
 *   <li>第 2 行：n 个整数，空格分隔
 *   <li>第 3 行：整数 target
 * </ul>
 *
 * <p>输出格式：一行，两个整数，空格分隔，为一对合法下标（从 0 开始）。若有多种答案，任意输出一对即可。
 *
 * <p>样例：
 * <pre>
 * 4
 * 2 7 11 15
 * 9
 * 输出：0 1
 * </pre>
 */
public class P001_TwoSum {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int [] ans = towSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    } 
    

    private static int[] towSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                ans[1] = i;
                ans[0] = map.get(target-x);
            }else{
                map.put(x, i);
            }
        }
        return ans;
    }

    
}
