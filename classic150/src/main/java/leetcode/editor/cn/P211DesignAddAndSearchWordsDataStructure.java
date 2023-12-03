package leetcode.editor.cn;
//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ：
//
//
// WordDictionary() 初始化词典对象
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些
//'.' ，每个 . 都可以表示任何一个字母。
//
//
//
//
// 示例：
//
//
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 25
// addWord 中的 word 由小写英文字母组成
// search 中的 word 由 '.' 或小写英文字母组成
// 最多调用 10⁴ 次 addWord 和 search
//
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 531 👎 0

//Java：211. 添加与搜索单词 - 数据结构设计
public class P211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        Node head = new Node();

        public WordDictionary() {

        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();

            Node pre = head;
            for (char c : chars) {
                Node node = pre.children[c - 'a'];
                if (node == null) {
                    node = new Node();
                    pre.children[c - 'a'] = node;
                }
                pre = node;
            }

            pre.isEnd = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            return backtracking(chars, head, 0);

        }

        public boolean backtracking(char[] chars, Node node, int index) {
            if (index == chars.length) {
                return node.isEnd;
            }

            char c = chars[index];
            if (c != '.') {
                Node next = node.children[c - 'a'];
                if (next != null && backtracking(chars, next, index + 1)) {
                    return true;
                }
            } else {
                for (Node child : node.children) {
                    if (child != null && backtracking(chars, child, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }


        class Node {
            Node[] children = new Node[26];
            boolean isEnd = false;

        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
