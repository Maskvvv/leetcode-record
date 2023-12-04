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
    public static int[] generateNumArray(String numArray) {
        numArray = numArray.replace("[", "");
        numArray = numArray.replace("]", "");

        String[] array = numArray.split(",");

        return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }
    public static String[] generateStringArray(String stringArray) {
        Pattern pattern = Pattern.compile("\"(\\w+?)\"");
        Matcher matcher = pattern.matcher(stringArray);

        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list.toArray(new String[0]);
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
        System.out.println(Arrays.toString(generateStringArray("[\"oath\",\"pea\",\"eat\",\"rain\"]")));
    }


    private static void print (List<Integer> num) {
        System.out.println(num);
    }

}
