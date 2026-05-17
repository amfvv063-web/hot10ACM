package hot100.binarysearch;

public class P_74sreachMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 3;
        boolean ans = search(matrix, target);
        System.out.println(ans);
    }

    private static boolean search(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] row : matrix) {
            int t = row[n - 1];
            if (target == t) {
                return true;
            } else if (target > t) {
                continue;
            } else if (target < t) {
                return lowerBound(row, target);
            }
        }
        return false;
    }

    // 正常写 找 >=x的第一个元素下标
    private static boolean lowerBound(int[] row, int target) {
        int l = -1;
        int r = row.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
