package com.ke.utopia.ailab;

import java.util.HashMap;

/**
 * 类名：TwoSum
 * 描述：
 * 作者：zifengchen
 * 日期：2025/11/14
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int[] result =  new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
