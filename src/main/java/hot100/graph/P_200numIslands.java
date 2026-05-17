package hot100.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class P_200numIslands {
    private static final int[][] DIRS = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        runCase("原题样例-一座大连岛", new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        }, 1);

        runCase("两座被水分开", new char[][] {
                { '1', '1', '0' },
                { '0', '0', '1' }
        }, 2);

        runCase("全水", new char[][] {
                { '0', '0' },
                { '0', '0' }
        }, 0);

        runCase("单格陆地", new char[][] {
                { '1' }
        }, 1);

        runCase("对角不相连-两座", new char[][] {
                { '1', '0' },
                { '0', '1' }
        }, 2);

        runCase("三座独立小岛", new char[][] {
                { '1', '0', '1', '0', '1' },
                { '0', '0', '0', '0', '0' }
        }, 3);

        runCase("LeetCode示例-一座", new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        }, 1);

        runCase("一行多块陆地", new char[][] {
                { '1', '0', '1', '0', '1' }
        }, 3);
    }

    private static void runCase(String name, char[][] grid, int expect) {
        int dfs = numIsland(grid);
        int bfs = numIsland1(grid);
        boolean ok = dfs == expect && bfs == expect;
        System.out.printf("%s | expect=%d dfs=%d bfs=%d %s%n",
                name, expect, dfs, bfs, ok ? "OK" : "FAIL");
    }

    // DFS写法
    private static int numIsland(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] vist = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vist[i][j]) {
                    dfs(grid, i, j, vist);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] vist) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vist[i][j] || grid[i][j] != '1') {
            return;
        }
        vist[i][j] = true;
        for (int[] dirs : DIRS) {
            int x = i + dirs[0];
            int y = j + dirs[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                dfs(grid, x, y, vist);
            }
        }
    }

    // BFS写法
    private static int numIsland1(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] vist = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vist[i][j]) {
                    bfs(grid, i, j, vist);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void bfs(char[][] grid, int i, int j, boolean[][] vist) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        vist[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int[] dirs : DIRS) {
                int x = r + dirs[0];
                int y = c + dirs[1];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1' && !vist[x][y]) {
                    vist[x][y] = true;
                    q.offer(new int[] { x, y });
                }
            }

        }
    }
}
