package hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p_56intervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.substring(1, line.length()-1);
        String[]paStrings = line.split("\\],\\[");
        int[][] intervals = new int[paStrings.length][2];
        for (int i = 0; i < intervals.length; i++) {
            String t = paStrings[i].replace("[", "").replace("]", "");
            String[] ab = t.split(",");
            intervals[i][0] = Integer.parseInt(ab[0].trim());
            intervals[i][1] = Integer.parseInt(ab[1].trim());
        }
        int[][] ans = merge(intervals);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.length; i++) {
            sb.append("[");
            sb.append(ans[i][0]);
            sb.append(",");
            sb.append(ans[i][1]);
            sb.append("]");
            if (i < ans.length-1){sb.append(",");}
        }
        sb.append("]");
        System.out.println(sb);
    }
    
    //逻辑判断 第二位在区间就 取 两者最大， 不在就把该区间全部加入
    private static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (p,q) -> p[0] - q[0]);
        for(int[] p : intervals){
            int m = res.size();
            int x = p[0];
            int y = p[1];
            if (m>0 && res.get(m-1)[1]>= x) {
                res.get(m-1)[1] = Math.max(y, res.get(m-1)[1]);
            }else{
                res.add(p);
            }
        }
        int n = res.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;

        }
    }
