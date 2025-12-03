package com.ke.utopia.ailab;

/**
 * 类名：MinimumSizeSubarraySum
 * 描述：给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 作者：zifengchen
 * 日期：2025/12/3
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] array = new int[]{1,4,4};

        int i = minSubArrayLen_1(4, array);

        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            if (nums[i] >= target) {
                return 1;
            }

            for (int j = i + 1; j < length; j++) {
                temp += nums[j];
                if (temp >= target) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static int minSubArrayLen_1(int target, int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        int left = 0;
        int right = 0;

        int temp = 0;
        int minLen = Integer.MAX_VALUE;

        for (; right < length; right++) {
            temp += nums[right];

            while (left <= right && temp >= target) {
                minLen = Math.min(minLen, right - left + 1);
                temp -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
