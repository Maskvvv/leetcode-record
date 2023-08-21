package leetcode.editor.cn.utils;

import java.util.Arrays;

/**
 * 图工具类
 *
 * @author zhouhongyin
 * @since 2023/8/21 22:54
 */
public class GridUtils {

    public static int[][] generateGrid(String grid) {

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

        return res;
    }


}
