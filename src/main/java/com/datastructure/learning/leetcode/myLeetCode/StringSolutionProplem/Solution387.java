package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

import java.util.*;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 相关标签：哈希表 字符串
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution387 {

    /**
     * 不知道写的是啥，思路混乱，要想清楚再写代码！！！
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char [] chars=s.toCharArray();
        Map<Integer,Character> hashMap=new HashMap<>();
        // 将数组存入map key表述索引，value为数组元素
        for (int i=0;i<chars.length;i++){
            hashMap.put(i,chars[i]);
        }

        // 查询map中是否包含相同的value，相同就返回索引key
        Set<Map.Entry<Integer,Character>> entrySet = hashMap.entrySet();
        for(Map.Entry<Integer,Character> e:entrySet) { // 遍历map
            if(hashMap.containsValue(e.getValue())){
            System.out.println("1重复元素："+e.getKey()+":"+e.getValue());
            } else {
                System.out.println("2不重复元素："+e.getKey()+":"+e.getValue());
                return e.getKey(); // 范湖第一个不重复的value对应的key
            }
        }
      return -1;
    }

    /**
     * 官方解题思路说明
     * 方法一：使用哈希表存储频数
     * 思路与算法
     * 我们可以对字符串进行两次遍历。
     * 在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。
     * 在第二次遍历时，我们只要遍历到了一个只出现一次的字符，那么就返回它的索引，否则在遍历结束后返回 -1。
     *
     * getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
     *
     * 复杂度分析
     * 时间复杂度：O(n)O(n)，其中 nn 是字符串 ss 的长度。我们需要进行两次遍历。
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 是字符集，在本题中 ss 只包含小写字母，因此 |\Sigma| \leq 26∣Σ∣≤26。我们需要 O(|\Sigma|)O(∣Σ∣) 的空间存储哈希映射。
     * @param s
     * @return
     */
    public int firstUniqChar_a(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二：使用哈希表存储索引
     * 思路与算法
     * 我们可以对方法一进行修改，使得第二次遍历的对象从字符串变为哈希映射。
     * 具体地，对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者 −1（如果该字符出现多次）。当我们第一次遍历字符串时，设当前遍历到的字符为 cc，如果 cc 不在哈希映射中，我们就将 cc 与它的索引作为一个键值对加入哈希映射中，否则我们将 cc 在哈希映射中对应的值修改为 −1。
     * 在第一次遍历结束后，我们只需要再遍历一次哈希映射中的所有值，找出其中不为 −1 的最小值，即为第一个不重复字符的索引。如果哈希映射中的所有值均为 −1，我们就返回 −1。
     *
     * 复杂度分析
     * 时间复杂度：O(n)O(n)，其中 nn 是字符串 ss 的长度。第一次遍历字符串的时间复杂度为 O(n)O(n)，第二次遍历哈希映射的时间复杂度为 O(|\Sigma|)O(∣Σ∣)，由于 ss 包含的字符种类数一定小于 ss 的长度，因此 O(|\Sigma|)O(∣Σ∣) 在渐进意义下小于 O(n)O(n)，可以忽略。
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 是字符集，在本题中 ss 只包含小写字母，因此 |\Sigma| \leq 26∣Σ∣≤26。我们需要 O(|\Sigma|)O(∣Σ∣) 的空间存储哈希映射。
     * @param s
     * @return
     */
    public int firstUniqChar_b(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }

    /**
     * 方法三：队列
     * 思路与算法
     * 我们也可以借助队列找到第一个不重复的字符。队列具有「先进先出」的性质，因此很适合用来找出第一个满足某个条件的元素。
     * 具体地，我们使用与方法二相同的哈希映射，并且使用一个额外的队列，按照顺序存储每一个字符以及它们第一次出现的位置。当我们对字符串进行遍历时，设当前遍历到的字符为 cc，如果 cc 不在哈希映射中，我们就将 cc 与它的索引作为一个二元组放入队尾，否则我们就需要检查队列中的元素是否都满足「只出现一次」的要求，即我们不断地根据哈希映射中存储的值（是否为 -1−1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。
     * 在遍历完成后，如果队列为空，说明没有不重复的字符，返回 −1，否则队首的元素即为第一个不重复的字符以及其索引的二元组。
     *
     * 小贴士
     * 在维护队列时，我们使用了「延迟删除」这一技巧。也就是说，即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。
     * 只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
     * @param s
     * @return
     */
    public int firstUniqChar_c(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }



    public int firstUniqChar_1(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_2(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        // s全部存到哈希表中
        for (char ch : chars) {
            freq[ch - 'a']++; //ch-'a' 遍历s将字符串存到哈希表中，重复的加一
           // System.out.println("freq[ch - 'a']++表示的意思是什么："+freq[ch - 'a']);
        }
        for (int i = 0; i < chars.length; i++) {
            //
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_4(String s) {
        boolean[] notUniq = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!notUniq[ch -'a']) {
                if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                    return i;
                } else {
                    notUniq[ch - 'a'] = true;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar_5(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    /**
     * 用字符数组
     * @param s
     * @return
     */
    public int firstUniqChar_6(String s) {
        char[] map = new char[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        String s = "loveleetcode";
       int in= new Solution387().firstUniqChar_2(s);
        System.out.println(in);
    }
}
