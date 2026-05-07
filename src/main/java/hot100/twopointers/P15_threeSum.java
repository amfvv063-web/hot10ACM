package hot100.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P15_threeSum {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine().trim();
    line = line.substring(1, line.length()-1);
    String[] parts = line.split(",");
    int[] nums = new int[parts.length];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(parts[i]);
    }
    List<List<Integer>> ans = threeSum(nums);
    print(ans);
}

private static void print(List<List<Integer>> ans) {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (List<Integer> xList : ans) {
        sb.append(xList);
        sb.append(',');
    }
    sb.append(']');
    System.out.println(sb);
}

private static List<List<Integer>> threeSum(int[] nums) {
   Arrays.sort(nums);
   List<List<Integer>> ans = new ArrayList<>();
   for (int i = 0; i < nums.length; i++) {
    int x = nums[i];
    if (i>0 && x == nums[i-1]) {
        continue;
    }
    if (x > 0) {
        break;
    }
    int target = -x; 
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = i+1; j < nums.length; j++) {
        int y = nums[j];
        
        if (map.containsKey(target - y)) {
            ans.add(new ArrayList<Integer>(Arrays.asList(x, y, target - y )));
            while (j+1<nums.length && y == nums[j+1]) {
                j++;
            }
        }else{
            map.put(y, y);
        }
    }
    map.clear();
   }
   return ans;
}
}
