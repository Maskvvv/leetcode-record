package leetcode.editor.cn.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static List<String> generateStringArray(String str) {
        List<String> res= new ArrayList<>();
        Matcher matcher = Pattern.compile("(\\w+)").matcher(str);
        while (matcher.find()) {
            res.add(matcher.group(1));
        }
        return res;
    }

}
