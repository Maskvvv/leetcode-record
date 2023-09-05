package leetcode.editor.cn;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
//
// Related Topics 数组 哈希表 字符串 排序 👍 1601 👎 0


import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：49. 字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {

        char[] a = {'t', 'a', 'e'};
        char[] b = {'e', 'a', 't'};

        System.out.println(Arrays.hashCode(a));
        System.out.println(Arrays.hashCode(b));

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.hashCode(a));
        System.out.println(Arrays.hashCode(b));

        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        solution.groupAnagrams(strs);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            Map<Integer, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] hashChar = str.toCharArray();
                Arrays.sort(hashChar);
                int hashCode = Arrays.hashCode(hashChar);

                List<String> list = map.getOrDefault(hashCode, new ArrayList<>());
                list.add(str);
                map.put(hashCode, list);

                if (list.size() == 1) res.add(list);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)



}
