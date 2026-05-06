package common;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * Hot 100 / 常见 OJ 的<strong>标准输出</strong>写法对照表（仅作模板，解题时按需复制或对照）。
 *
 * <p>约定：若无特别说明，均在行末输出换行（{@code println}）。数组/矩阵默认<strong>空格分隔、无多余尾部空格</strong>（多数 OJ 友好）。
 *
 * <p>注意：具体题目以题面为准（下标从 0 还是 1、是否要打印个数、是否多组数据等）。
 */
public final class AcmOutputTemplates {

    private AcmOutputTemplates() {}

    // region 标量

    /** 输出一个整数并换行。 */
    public static void printIntLine(PrintStream out, int x) {
        out.println(x);
    }

    /** 输出一个长整并换行。 */
    public static void printLongLine(PrintStream out, long x) {
        out.println(x);
    }

    /** 输出一个双精度，保留 {@code scale} 位小数并换行（常见：6 位）。 */
    public static void printDoubleLine(PrintStream out, double x, int scale) {
        out.printf("%." + scale + "f%n", x);
    }

    /** 输出一行字符串（整行即答案）。 */
    public static void printStringLine(PrintStream out, String s) {
        out.println(s);
    }

    /** 输出 {@code true}/{@code false} 并换行（题面要求小写时）。 */
    public static void printBooleanLowerLine(PrintStream out, boolean b) {
        out.println(b);
    }

    /** 输出 {@code YES}/{@code NO} 并换行（部分 OJ 题面约定大写）。 */
    public static void printYesNoLine(PrintStream out, boolean ok) {
        out.println(ok ? "YES" : "NO");
    }

    /** 输出 {@code Yes}/{@code No} 并换行（题面若要求首字母大写）。 */
    public static void printYesNoCapitalizedLine(PrintStream out, boolean ok) {
        out.println(ok ? "Yes" : "No");
    }

    // endregion

    // region 一维 int / long（一行空格分隔）

    /**
     * 一行输出 {@code n} 个整数，空格分隔，末尾换行。空数组输出空行。
     *
     * <p>适用：返回数组、排列、下标列表等（Hot 100 里很常见）。
     */
    public static void printIntsSpaceLine(PrintStream out, int[] a) {
        if (a == null || a.length == 0) {
            out.println();
            return;
        }
        StringJoiner j = new StringJoiner(" ");
        for (int v : a) {
            j.add(Integer.toString(v));
        }
        out.println(j);
    }

    /** 同上，类型为 {@code long[]}。 */
    public static void printLongsSpaceLine(PrintStream out, long[] a) {
        if (a == null || a.length == 0) {
            out.println();
            return;
        }
        StringJoiner j = new StringJoiner(" ");
        for (long v : a) {
            j.add(Long.toString(v));
        }
        out.println(j);
    }

    /**
     * 先输出长度 {@code n}，换行；再输出 {@code n} 个整数（空格分隔）并换行。
     *
     * <p>适用：题面要求「第一行个数，第二行元素」时。
     */
    public static void printSizeThenIntsSpace(PrintStream out, int[] a) {
        if (a == null) {
            out.println(0);
            out.println();
            return;
        }
        out.println(a.length);
        printIntsSpaceLine(out, a);
    }

    /**
     * 每个整数单独一行（例如输出多个查询结果、或多个下标各占一行——以题面为准）。
     */
    public static void printIntsOnePerLine(PrintStream out, int[] a) {
        if (a == null) {
            return;
        }
        for (int v : a) {
            out.println(v);
        }
    }

    // endregion

    // region 二维矩阵

    /**
     * 输出矩阵：每行空格分隔整数，共 {@code row} 行；行末均换行。
     *
     * <p>适用：网格、DP 表、图邻接权值等（题面不要求先输出 n、m 时）。
     */
    public static void printIntMatrix(PrintStream out, int[][] g) {
        if (g == null) {
            return;
        }
        for (int[] row : g) {
            printIntsSpaceLine(out, row);
        }
    }

    /**
     * 先输出 {@code n m}，换行；再输出 {@code n} 行 {@code m} 列。
     *
     * <p>适用：题面明确要求带维度输出时。
     */
    public static void printIntMatrixWithSize(PrintStream out, int[][] g) {
        if (g == null || g.length == 0) {
            out.println("0 0");
            return;
        }
        int n = g.length;
        int m = g[0].length;
        out.println(n + " " + m);
        printIntMatrix(out, g);
    }

    // endregion

    // region List / Collection

    /** {@code List<Integer>} 一行空格分隔。 */
    public static void printIntegerListSpaceLine(PrintStream out, List<Integer> list) {
        if (list == null || list.isEmpty()) {
            out.println();
            return;
        }
        StringJoiner j = new StringJoiner(" ");
        for (Integer v : list) {
            j.add(Integer.toString(v));
        }
        out.println(j);
    }

    /** {@code List<String>} 一行空格分隔（字符串本身不含空格时较安全）。 */
    public static void printStringListSpaceLine(PrintStream out, List<String> list) {
        if (list == null || list.isEmpty()) {
            out.println();
            return;
        }
        StringJoiner j = new StringJoiner(" ");
        for (String s : list) {
            j.add(s);
        }
        out.println(j);
    }

    /**
     * 多行列表：每个内层列表一行、元素空格分隔。
     *
     * <p>适用：形如「输出若干行，每行若干个整数」的题（组合、子集列表等，以题面为准）。
     */
    public static void printNestedListLines(PrintStream out, List<List<Integer>> nested) {
        if (nested == null) {
            return;
        }
        for (List<Integer> row : nested) {
            printIntegerListSpaceLine(out, row);
        }
    }

    // endregion

    // region 点对、边、坐标

    /** 一行两个整数，空格分隔（如两个下标、一条无向边的一个端点表示等）。 */
    public static void printPairSpaceLine(PrintStream out, int a, int b) {
        out.println(a + " " + b);
    }

    /** 多对点：每行一对 {@code a b}。 */
    public static void printPairsLines(PrintStream out, int[][] pairs) {
        if (pairs == null) {
            return;
        }
        for (int[] p : pairs) {
            if (p != null && p.length >= 2) {
                printPairSpaceLine(out, p[0], p[1]);
            }
        }
    }

    // endregion

    // region 多组答案逐行（T 组查询）

    /**
     * 已有 {@code answers} 集合时，每个答案单独一行输出（常见于多测）。
     *
     * <p>若题面要求先输出 T 再输出 T 行，请在调用前自行输出 T。
     */
    public static void printLines(PrintStream out, Collection<?> lines) {
        if (lines == null) {
            return;
        }
        for (Object o : lines) {
            out.println(o);
        }
    }

    // endregion

    // region 字符矩阵 / 字符串数组

    /**
     * 字符二维网格：每行一个 {@code String}（不含行间空格）。
     *
     * <p>适用：迷宫、棋盘 {@code char[][]}。
     */
    public static void printCharGrid(PrintStream out, char[][] grid) {
        if (grid == null) {
            return;
        }
        for (char[] row : grid) {
            out.println(new String(row));
        }
    }

    /** 每行一个字符串。 */
    public static void printStringLines(PrintStream out, String[] lines) {
        if (lines == null) {
            return;
        }
        for (String s : lines) {
            out.println(s);
        }
    }

    // endregion

    // region System.out 便捷重载（本地对照最常用）

    public static void printIntLine(int x) {
        printIntLine(System.out, x);
    }

    public static void printLongLine(long x) {
        printLongLine(System.out, x);
    }

    public static void printDoubleLine(double x, int scale) {
        printDoubleLine(System.out, x, scale);
    }

    public static void printStringLine(String s) {
        printStringLine(System.out, s);
    }

    public static void printBooleanLowerLine(boolean b) {
        printBooleanLowerLine(System.out, b);
    }

    public static void printYesNoLine(boolean ok) {
        printYesNoLine(System.out, ok);
    }

    public static void printIntsSpaceLine(int[] a) {
        printIntsSpaceLine(System.out, a);
    }

    public static void printLongsSpaceLine(long[] a) {
        printLongsSpaceLine(System.out, a);
    }

    public static void printSizeThenIntsSpace(int[] a) {
        printSizeThenIntsSpace(System.out, a);
    }

    public static void printIntsOnePerLine(int[] a) {
        printIntsOnePerLine(System.out, a);
    }

    public static void printIntMatrix(int[][] g) {
        printIntMatrix(System.out, g);
    }

    public static void printIntMatrixWithSize(int[][] g) {
        printIntMatrixWithSize(System.out, g);
    }

    public static void printIntegerListSpaceLine(List<Integer> list) {
        printIntegerListSpaceLine(System.out, list);
    }

    public static void printStringListSpaceLine(List<String> list) {
        printStringListSpaceLine(System.out, list);
    }

    public static void printNestedListLines(List<List<Integer>> nested) {
        printNestedListLines(System.out, nested);
    }

    public static void printPairSpaceLine(int a, int b) {
        printPairSpaceLine(System.out, a, b);
    }

    public static void printPairsLines(int[][] pairs) {
        printPairsLines(System.out, pairs);
    }

    public static void printLines(Collection<?> lines) {
        printLines(System.out, lines);
    }

    public static void printCharGrid(char[][] grid) {
        printCharGrid(System.out, grid);
    }

    public static void printStringLines(String[] lines) {
        printStringLines(System.out, lines);
    }
}
