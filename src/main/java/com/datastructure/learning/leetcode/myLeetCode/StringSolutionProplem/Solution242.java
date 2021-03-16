package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 相关标签: 排序 哈希表
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
       return false;
    }

    /**
     * 秒啊
     * 方法一、先排序，在比较
     * 先把两个字符串转化为字符数组，然后再对这两个字符数组进行排序，因为相同的字符在排序之后肯定是挨着的，最后再比较这两个排序后的数组的元素是否相同。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_1(String s, String t) {
        //特判，长度不同必定不是
        if (s.length()!=t.length()) return false;
        //两个字符串排序后是否相等
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);
    }

    /**
     * 方法二、计算两个字符串中字符的差值
     * 先统计字符串s中每个字符的数量
     * 减去t中每个字符对应的数量
     * 如果最后结果都是0，说明t是s的字母异位词。
     *
     * 1、s.charAt(i)-'a' 遍历s将字符串存到哈希表中，重复的加一
     * 2、遍历t、将哈希表减一，如果哈希表没有全为0，证明有不相同的字母
     * @param s anagram
     * @param t
     * @return
     */
    public boolean isAnagram_2(String s, String t) {
        int[] ints = new int[26];
        // s全部存到哈希表中
        for (int i = 0; i < s.length(); i++) {
            //System.out.print("元素："+s.charAt(i)+" ");
            //System.out.print("元素在数组中的索引位置："+(s.charAt(i)-'a')+" ");
            ints[s.charAt(i)-'a']++;
        }
        //System.out.println("每个元素在数组中出现的次数："+Arrays.toString(ints));
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;
            // 如果已经出现不一致的提前返回
            if(ints[t.charAt(i)-'a'] <0){
                return false;
            }
        }
        System.out.println("每个元素在数组中出现的次数："+Arrays.toString(ints));
        // 遍历哈希表，不为0表示不一致
        for (int anInt : ints) {
            if(anInt != 0){
                return false;
            }
        }
        //System.out.println("最后hash表中的元素应该都为0："+Arrays.toString(ints));
        return true;
    }

    /**
     * 秒啊
     * 方法三、一次遍历
     * 还可以使用另外一种方式，这种实现方式不太容易想到。
     * 使用一个变量count记录新出现字符的个数，然后同时遍历两个数组，如果出现了一个新的字符，count就加1，如果消失了一个字符，count就减1，最后判断count是否等于0即可。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_3(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            //出现了一个新的字符
            if (++map[cs[i] - 'a'] == 1) {
                count++;
            }
            //消失了一个新的字符
            if (--map[ct[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }


    public static void main(String[] args) {
         String s = "anagram", t = "nagaram";
         boolean b=new Solution242().isAnagram_2(s,t);
        System.out.println(b);
    }

}
