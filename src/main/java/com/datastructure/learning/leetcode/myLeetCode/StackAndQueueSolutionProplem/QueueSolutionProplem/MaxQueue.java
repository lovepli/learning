package com.datastructure.learning.leetcode.myLeetCode.StackAndQueueSolutionProplem.QueueSolutionProplem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 59688
 * @date: 2021/3/23
 * @description: 面试题 59 - II. 队列的最大值
 * 题目描述
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是 O(1)。
 *
 * 若队列为空，pop_front 和 max_value  需要返回 -1
 *
 * 示例 1:
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * Copy to clipboardErrorCopied
 * 示例 2:
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * Copy to clipboardErrorCopied
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * 解法
 */
class MaxQueue {
    private Deque<Integer> p;
    private Deque<Integer> q;

    public MaxQueue() {
        p = new ArrayDeque<>();
        q = new ArrayDeque<>();
    }

    public int max_value() {
        return q.isEmpty() ? -1 : q.peekFirst();
    }

    public void push_back(int value) {
        while (!q.isEmpty() && q.peekLast() < value) {
            q.pollLast();
        }
        p.offerLast(value);
        q.offerLast(value);
    }

    public int pop_front() {
        if (p.isEmpty()) return -1;
        int res = p.pollFirst();
        if (q.peek() == res) q.pollFirst();
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

