package leetcode.editor.cn;
//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
//
//
//
// 示例 1：
//
//
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
//
//
// 示例 2：
//
//
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 30
// 所有输入的字符串 words[i] 都只包含小写字母。
//
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 301 👎 0


//Java：词典中最长的单词
public class P720LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new P720LongestWordInDictionary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            String res = "";
            for (String word : words) {
                if (trie.search(word)) {
                    if(word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                        res = word;
                    }
                }
            }

            return res;

        }

        private class Trie {
            private Trie[] children;
            private Boolean isEnd;

            public Trie() {
                this.children = new Trie[26];
                this.isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char cha = word.charAt(i);
                    int index = cha - 'a';
                    if (node.children[index] == null) node.children[index] = new Trie();
                    node = node.children[index];
                }
                node.isEnd = true;
            }

            public boolean search(String word) {
                Trie node = searchPrefix(word);
                return node != null && node.isEnd;
            }

            public Trie searchPrefix(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char cha = word.charAt(i);
                    int index = cha - 'a';
                    if (node.children[index] == null || !node.children[index].isEnd) {
                        return null;
                    }
                    node = node.children[index];
                }

                return node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
