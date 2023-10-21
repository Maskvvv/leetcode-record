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

    public static <T> List<T>  generateArray(String str) {
        List<T> res= new ArrayList<>();
        Matcher matcher = Pattern.compile("(\\w+)").matcher(str);
        while (matcher.find()) {
            res.add((T) matcher.group(1));
        }
        return res;
    }


    public static void main(String[] args) {
        List<String> array = generateArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]");

        System.out.println(array);


        List<Integer> num = generateArray("[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]");
        System.out.println(num);


        System.out.println(generateArray("[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]"));

        print(generateArray("[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]"));
    }


    private static void print (List<Integer> num) {
        System.out.println(num);
    }

}
