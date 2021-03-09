package com.datastructure.learning.datastucture.myLeetCode;

import cn.hutool.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 两数之和
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Solution1 {

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    @Test
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                     return new int[]{i,j};
                }
            }
        }
       return new int[0];
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4,6,7};
        int target=8;
        JSONArray jsonArray=new JSONArray(new Solution1().twoSum(nums,target));
        System.out.println("两数之和："+jsonArray.toString());
    }


}
