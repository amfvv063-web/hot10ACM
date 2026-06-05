package hot100.dp;

import java.util.ArrayList;
import java.util.List;

public class P_118generateTanc {
    public static void main(String[] args) {
        int numBows = 5;
        List<List<Integer>> ans = generate(numBows);
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < ans.size(); i++) {
            sb.append("[");
            List<Integer> list = ans.get(i);
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j != list.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i != ans.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    //左对齐  最开始和最末尾都是1 中间规律是dfs(i,j)
    private static List<List<Integer>> generate(int numBows) {
        //dfs(i， j) -> 第i行 第J列 最大值 dfs(i, j) = dfs(i-1, j) + dfs(i-1, j-1)
        // s[i][j] = 1, s[0,0] = 1;
        List<List<Integer>> ans = new ArrayList<>(numBows);
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        for (int i = 1; i < numBows; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
            }
            res.add(1);
            ans.add(res);
        }
        return ans;

    }
}
