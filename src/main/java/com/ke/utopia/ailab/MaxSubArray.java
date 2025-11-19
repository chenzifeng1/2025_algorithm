package com.ke.utopia.ailab;

import java.util.Map;

/**
 * 类名：MaxSubArray
 * 描述：
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 作者：zifengchen
 * 日期：2025/11/19
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = new int[] {5,4,-1,7,8};

        int result = maxSubArray(array);
        System.out.println(result);

    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length + 1];

        dp[0] = nums[0];
        int temp = dp[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (temp < dp[i]) {
                temp = dp[i];
            }

        }
        return temp;

    }
}
