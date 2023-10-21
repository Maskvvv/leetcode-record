package leetcode.editor.cn;
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk：
//
//
// 每一对相邻的单词只差一个字母。
//
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
//
// sk == endWord
//
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。
//
// 示例 1：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
//
// 示例 2：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。
//
//
//
// 提示：
//
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord、endWord 和 wordList[i] 由小写英文字母组成
// beginWord != endWord
// wordList 中的所有字符串 互不相同
//
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1311 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：127. 单词接龙
public class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
        System.out.println(solution.ladderLength("hit", "cog", ArrayUtils.generateArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]")));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordList.contains(endWord)) return 0;

            Deque<String> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            int count = 1;
            queue.addLast(beginWord);

            while (!queue.isEmpty()) {

                Deque<String> nextQueue = new ArrayDeque<>();

                while (!queue.isEmpty()) {
                    String word = queue.removeFirst();
                    for (int i = 0; i < word.length(); i++) {
                        char[] chars = word.toCharArray();
                        char c = chars[i];
                        for (int j = 0; j < 26; j++) {
                            if (c == 'a' + j) continue;
                            chars[i] = (char) ('a' + j);
                            String nextWord = new String(chars);
                            if (!visited.contains(nextWord) && wordSet.contains(nextWord)) {
                                visited.add(nextWord);
                                nextQueue.add(nextWord);

                                if (nextWord.equals(endWord)) {
                                    return count + 1;
                                }
                            }
                        }
                        chars[i] = c;
                    }
                }

                count++;
                queue = nextQueue;
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
