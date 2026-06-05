package hot100.backtrack;

public class P_79exist {
    private static int[][] DIRS = {{1,0}, {-1, 0}, {0,-1}, {0,1}};
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                            {'S', 'F','C','S'},
                            {'A', 'D', 'E','E'}};
        String word = "ABCCED";
        boolean ans = findWord(board, word);
        System.out.println(ans);
    }

    //DFS找连通块 + 数值匹�?    private static boolean findWord(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char x = board[i][j];
                if (x == words[0]) {
                    if (dfs(i, j , vis, board, 0, words)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Boolean dfs(int i, int j, boolean[][] vis, char[][] board, int k, char[] words) {
        if (i<0 || i>= board.length || j<0||j>= board[0].length||vis[i][j]) {
            return false;
        }
        
        if (board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length-1) {
            return true;
        }
        vis[i][j] = true;
        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1];
            if (dfs(x, y, vis, board, k+1, words)) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    

    }
}
