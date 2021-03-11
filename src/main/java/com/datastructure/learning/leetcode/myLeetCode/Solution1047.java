package com.datastructure.learning.leetcode.myLeetCode;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1047 {

    /**
     *https://zhidao.baidu.com/question/716581200478788125.html
     * @param S
     * @return
     */
    //public String removeDuplicates(String S) {
    //    char [] strArray = S.toCharArray();
    //    int serLen=strArray.length;
    //    for(int i=0;i<serLen-1;i++){
    //        for(int j=i+1;j<serLen;j++){
    //            if(strArray[j]==strArray[i]){
    //                System.out.println("相同");
    //                int k;
    //                for(k=j+1;k<serLen;k++){
    //                    strArray[i]=strArray[k];
    //                }
    //                serLen=serLen-k;
    //            }
    //        }
    //    }
    //    for(char c:strArray){
    //        System.out.println(c);
    //    }
    //  return strArray.toString();
    //}

    /**
     * 用数组代替集合能够快速提高效率，把 charsArray 当成栈就不会持续申请内存空间。
     * <p>
     * 思考：原来string类本身也可以当作栈
     *
     * @param S aabcbbca
     * @return
     */
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int index = -1; // 定义栈指针
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
                // System.out.println("相同--"+index+"--"+i);
            } else {
                index++;
                //  System.out.println("不相同--"+index+"--"+i);
                chars[index] = chars[i];
            }
        }
       // System.out.println("得到的字符串：" + String.copyValueOf(chars)); // babcbbca ?? 得到的这个chars数组代表的是什么？
        return String.copyValueOf(chars, 0, index + 1); //ba  TODO 解释：数组从索引0开始的index+1=2个字符将被复制到字符串
    }
    //public static String copyValueOf(char[] data): 返回指定数组中表示该字符序列的字符串。
    //
    //public static String copyValueOf(char[] data, int offset, int count): 返回指定数组中表示该字符序列的 字符串。
    // offset是需要复制字符的初始索引，count是要复制的字符数。对于例如offset 2 和count 3 将被解释为：数组从第 2 个索引开始的仅仅 3 个字符（第 3 个位置因为索引从 0 开始）应该被复制到相关的String。

    /**
     * 由1代码精简过来
     * @param S
     * @return
     */
    public String removeDuplicates4(String S) {
        char[] chars = S.toCharArray();
        int index = -1; // 定义栈指针
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
            } else {
               // index++; //将两行合并为一行
               // chars[index] = chars[i];
                chars[++index] = chars[i];
            }
        }
        return String.copyValueOf(chars, 0, index + 1); //ba  解释：数组从索引0开始的index+1=2个字符将被复制到字符串
    }
    /**
     * 网友：利用栈的数据结构，自定义栈，时间4 ms，击败99.4%
     * 这里不好理解，建议画图理解
     *
     * @param S aabcbbca
     * @return
     */
    public String removeDuplicates3(String S) {
        int n = S.length();
        char[] chars = S.toCharArray();//转为字符数组
        char[] stack = new char[n];//定义栈
        int top = -1; //定义栈指针
        //以下for循环将不重复的字符存放在栈里
        for (int j = 0; j < n; j++) {
            if (top > -1 && stack[top] == chars[j]) {
                top--;//栈针移动，代替真实出栈
            } else {
                stack[++top] = chars[j];//根据栈针移动直接覆盖重复的值
            }
        }
        //以下打印栈内不重复的字符
        char[] ans = new char[top + 1];
        for (int i = 0; i < top + 1; i++) {
            ans[i] = stack[i];
        }
        //通过有参构造传递字符数组，直接创建字符串对象
        String str = new String(ans);
        return str;
    }

    /**
     * 网友1：脑回路清晰，硬破解
     *
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        int now = S.length();
        int next = 1;
        while (now != next) {
            now = S.length();
            S = S.replace("aa", "").replace("bb", "").replace("cc", "").replace("dd", "").replace("ee", "").replace("ff", "").replace("gg", "").replace("hh", "").replace("ii", "").replace("jj", "").replace("kk", "").replace("ll", "").replace("mm", "").replace("nn", "").replace("oo", "").replace("pp", "").replace("qq", "").replace("rr", "").replace("ss", "").replace("tt", "").replace("uu", "").replace("vv", "").replace("ww", "").replace("xx", "").replace("yy", "").replace("zz", "");
            next = S.length();
        }
        return S;
    }


    /**
     * 根据索引index，删除byte字节数组元素
     */
    //private byte[] delByte(int index, byte[] b) {
    //    byte[] b2 = new byte[b.length];
    //    int j = 0;
    //    for (int i = 0; i < b.length; i++) {
    //        if (i == index)
    //            continue;
    //        j++;
    //        b2[j] = b[i];
    //    }
    //    return b2;
    //}
    public static void main(String[] args) {
        String str = "aabcbbca";
        System.out.println("返回的字符串为：" + new Solution1047().removeDuplicates4(str));
    }

}
