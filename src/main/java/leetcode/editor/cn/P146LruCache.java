package leetcode.editor.cn;
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类：
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 10⁵
// 最多调用 2 * 10⁵ 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2155 👎 0


import java.util.HashMap;
import java.util.Map;

//Java：LRU 缓存
public class P146LruCache {
    public static void main(String[] args) {
        //Solution solution = new P146LruCache().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        Map<Integer, LinkedNode> cache;
        // 队头指针，出队用
        LinkedNode head;
        // 队尾指针，进队用
        LinkedNode rear;
        // 当前存放的元素数量
        Integer size;
        // 缓存容量
        Integer capacity;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            cache = new HashMap<>();
            head = new LinkedNode();
            rear = new LinkedNode();
            head.next = rear;
            rear.prev = head;
        }

        public int get(int key) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            // 最近访问过的节点放入队尾
            removeAndOffer(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                // 新键值对：1. 放入队尾 2. 放入缓存 3. 当前 size + 1
                LinkedNode newNode = new LinkedNode(key, value);
                offer(newNode);
                cache.put(key, newNode);
                size++;
            } else {
                // 存在的节点：1. 更新该节点的值 2. 将改节点放到队尾
                node.value = value;
                removeAndOffer(node);
            }

            // 当当前节点数超过容量时，移除对头节点
            if (size > capacity) {
                LinkedNode firstNode = head.next;
                cache.remove(firstNode.key);
                remove(firstNode);
                size--;
            }

        }

        class LinkedNode {
            // 移除 cache 中的，键值对用
            Integer key;
            Integer value;
            // 指向对头方向
            LinkedNode prev;
            // 指向队尾方向
            LinkedNode next;

            LinkedNode() {
            }

            LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 移除当前元素
        public void remove(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 将节点放入队尾
        public void offer(LinkedNode node) {
            node.prev = rear.prev;
            node.next = rear;
            rear.prev.next = node;
            rear.prev = node;
        }

        // 删除当前元素放入队尾
        public void removeAndOffer(LinkedNode node) {
            remove(node);
            offer(node);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
