package leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 10⁴
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 816 👎 0

import leetcode.editor.cn.utils.ArrayUtils;
import leetcode.editor.cn.utils.GraphFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：212. 单词搜索 II
public class P212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
        // TO TEST

        System.out.println(solution.findWords(
                GraphFactory.buildArray("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"),
                ArrayUtils.generateStringArray("[\"oath\",\"pea\",\"eat\",\"rain\"]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        TrieNode trie = new TrieNode();
        int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[][] visited;

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];

            for (String word : words) {
                insert(word);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = board[i][j] - 'a';
                    if (trie.children[index] != null) {
                        visited[i][j] = true;
                        backtracking(board, i, j, trie.children[index]);
                        visited[i][j] = false;
                    }
                }
            }
            res.addAll(set);

            return res;
        }

        public void backtracking(char[][] board, int x, int y, TrieNode trieNode) {
            if (trieNode.s != null) {
                set.add(trieNode.s);
            }

            for (int[] p : position) {
                int nextX = x + p[0];
                int nextY = y + p[1];
                if (nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length && !visited[nextX][nextY]) {
                    int index = board[nextX][nextY] - 'a';
                    if (trieNode.children[index] != null) {
                        visited[nextX][nextY] = true;
                        backtracking(board, nextX, nextY, trieNode.children[index]);
                        visited[nextX][nextY] = false;
                    }
                }
            }
        }

        class TrieNode {
            String s;
            TrieNode[] children = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode pre = trie;

            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';

                if (pre.children[index] == null) {
                    pre.children[index] = new TrieNode();
                }
                pre = pre.children[index];
            }
            pre.s = word;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
