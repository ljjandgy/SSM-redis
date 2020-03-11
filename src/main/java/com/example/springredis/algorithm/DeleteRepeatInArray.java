package com.example.springredis.algorithm;

import java.io.Serializable;

/**
 * 删除排序数组中重复元素（采用原地算法）
 */
public class DeleteRepeatInArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //不相等，说明出现了不重复的内容，则需要把不重复的内容添加到nums[i+1]中，然后从nums[i+1]继续开始比较
            //相等说明重复，跳过即可
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;//不重复元素的长度，这个长度就是数组删除重复元素后剩下的内容，把这部分截取出来，就是不重复的元素数组了
    }

}
