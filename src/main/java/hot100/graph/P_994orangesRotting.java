package hot100.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P_994orangesRotting {
    private static final int[][] DIRS = {{0, -1}, {0, 1},{1,0}, {-1, 0}};
public static void main(String[] args) {
    int[][] grid ={
        {2,1,1},
        {1, 1,0},
        {0,1,1}
    };
    int ans = orange(grid);
    System.out.println(ans);
}
private static int orange(int[][] grid) {
   int m = grid.length;
   int n = grid[0].length;
   int ans = 0;
   int o = 0;
   //使用vist数组 统计每层步数
    int[][] vist = new int[m][n];
    Queue<int[]> q = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 2) {
                q.offer(new int[]{i, j});
            }else if (grid[i][j] == 1) {
                vist[i][j] = -1;
                o++;

            }
        }
    }
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int i = cur[0];
        int j = cur[1];
        for (int[] dirs : DIRS) {
            int x = dirs[0] + i;
            int y = dirs[1] + j;
            if (x>= 0 && y>=0 && x< grid.length&&y< grid[0].length && vist[x][y] == -1) {
                vist[x][y] = vist[i][j] +1;
                o--;
                q.offer(new int[]{x, y});
                ans = Math.max(ans, vist[x][y]);
            }
        }
    }
    return o == 0 ?ans:-1;
}
}
