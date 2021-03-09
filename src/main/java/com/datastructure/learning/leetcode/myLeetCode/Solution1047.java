package com.datastructure.learning.leetcode.myLeetCode;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 删除字符串中的所有相邻重复项
 */
public class Solution1047 {

    /**
     *https://zhidao.baidu.com/question/716581200478788125.html
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        char [] strArray = S.toCharArray();
        int serLen=strArray.length;
        for(int i=0;i<serLen-1;i++){
            for(int j=i+1;j<serLen;j++){
                if(strArray[j]==strArray[i]){
                    System.out.println("相同");
                    int k;
                    for(k=j+1;k<serLen;k++){
                        strArray[i]=strArray[k];
                    }
                    serLen=serLen-k;
                }
            }

        }
        for(char c:strArray){
            System.out.println(c);
        }
      return strArray.toString();
    }

    public String removeDuplicates2(String S) {
        int now =S.length();
        int next = 1;
        while(now != next){
            now =  S.length();
            S=S.replace("aa","").replace("bb","").replace("cc","").replace("dd","").replace("ee","").replace("ff","").replace("gg","").replace("hh","").replace("ii","").replace("jj","").replace("kk","").replace("ll","").replace("mm","").replace("nn","").replace("oo","").replace("pp","").replace("qq","").replace("rr","").replace("ss","").replace("tt","").replace("uu","").replace("vv","").replace("ww","").replace("xx","").replace("yy","").replace("zz","");
            next =  S.length();
        }
        return S;
    }



    /**
     * 根据索引index，删除byte字节数组元素
     */
   private byte[] delByte(int index, byte[] b) {
        byte[] b2 = new byte[b.length];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (i == index)
                continue;
            j++;
            b2[j] = b[i];
        }
        return b2;
    }


    public static void main(String[] args) {
        String str ="aabcbbca";
        System.out.println("返回的字符串为："+new Solution1047().removeDuplicates2(str));
    }

}
