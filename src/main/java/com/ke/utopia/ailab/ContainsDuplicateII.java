package com.ke.utopia.ailab;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：ContainsDuplicateII
 * 描述：给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * 作者：zifengchen
 * 日期：2025/12/8
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {


        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int temp = 1;
            while (i + temp < length && temp <= k) {
                if (nums[i] == nums[i + temp]) {
                    return true;
                }
                temp++;
            }
        }

        return false;
    }


    public boolean containsNearbyDuplicate_1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            Integer target = map.get(num);
            if ( target!= null && i- target <=k) {
                return true;
            }

            map.put(num,i);
        }

        return false;
    }

}
