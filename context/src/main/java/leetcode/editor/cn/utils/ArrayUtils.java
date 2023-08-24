package leetcode.editor.cn.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 数组工具类 </p>
 *
 * @author zhouhongyin
 * @since 2023/8/24 17:11
 */
public class ArrayUtils {
    public static int[] generateNumArray(String nums) {
        nums = nums.replace("[", "");
        nums = nums.replace("]", "");

        String[] array = nums.split(",");

        return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }

}
