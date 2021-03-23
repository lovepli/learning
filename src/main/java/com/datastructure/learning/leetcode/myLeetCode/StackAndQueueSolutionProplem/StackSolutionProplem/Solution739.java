package com.datastructure.learning.leetcode.myLeetCode.StackAndQueueSolutionProplem.StackSolutionProplem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 59688
 * @date: 2021/3/23
 * @description:
 * 题目描述
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {
    /**
     * 解法
     * 栈实现，栈存放 T 中元素的的下标 i，结果用数组 res 存储。
     *
     * 遍历 T，遍历到 T[i] 时：
     *
     * 若栈不为空，并且栈顶元素小于 T[i] 时，弹出栈顶元素 j，并且 res[j] 赋值为 i - j。
     * 然后将 i 压入栈中。
     * 最后返回结果数组 res 即可。
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && T[s.peek()] < T[i]) {
                int j = s.pop();
                res[j] = i - j;
            }
            s.push(i);
        }
        return res;
    }
}
