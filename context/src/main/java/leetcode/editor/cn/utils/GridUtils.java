package leetcode.editor.cn.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 图工具类
 *
 * @author zhouhongyin
 * @since 2023/8/21 22:54
 */
public class GridUtils {

    public static int[][] generateIntGrid(String grid) {

        int m = grid.split("],\\[").length;
        int n = grid.split("],\\[")[0].split(",").length;

        int[][] res = new int[m][n];

        grid = grid.replace("[", "");
        grid = grid.replace("]", "");

        int[] numArray = Arrays.stream(grid.split(",")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < m; i++) {
            int[] row = Arrays.copyOfRange(numArray, i * n, (i * n) + n);
            res[i] = row;
        }

        print(res);

        return res;
    }

    public static char[][] generateCharGrid(String grid) {
        char[][] chars = GraphFactory.buildArray(grid);
        GraphFactory.print(chars);
        return chars;
    }

    public static List<List<String>> generateStringGrid(String grid) {
        List<List<String>> lists = GraphFactory.build(grid);
        GraphFactory.print(lists);
        return lists;
    }

    public static void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + "  ");;
            }
            System.out.println();
        }

        System.out.println("---------------------");
    }

}
