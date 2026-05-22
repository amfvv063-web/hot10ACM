package hot100.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_207canFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        boolean ans = canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 三色标记法 0 -未访问 1- 正在访问 2-访问结束
        // 建立一个List列表， 统计每个目标节点的边， 形成一个拓扑
        // 建立color数组 -> 染色组
        // dfs找环 找到flase 找不到true
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        int[] color = new int[numCourses];
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0 && dfs(i, g, color)) {
                return false;
            }
        }
        return true;
        // 0 -> 1 1 -> 0 0 -> 1 1 -> 2

    }

    private static boolean dfs(int i, List<Integer>[] g, int[] color) {
        color[i] = 1;
        for (Integer xInteger : g[i]) {
            if (color[xInteger] == 1 || color[xInteger] == 0 && dfs(xInteger, g, color)) {
                return true;
            }
        }
        color[i] = 2;
        return false;
    }
}
