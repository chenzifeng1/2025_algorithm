package com.ke.utopia.ailab;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * <p>
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 n - 1
 * 作者：zifengchen
 * 日期：2025/11/21
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,1,4};
        int b = canJump(array);
        System.out.println(b);


    }


    public static int canJump(int[] nums) {
        // 动态规划
        int length = nums.length;

        // array[i]  到位置i最少需要到步数
        int[] array = new int[length + 1];
        for (int i = 1; i < array.length; i++) {
            array[i] = 10000;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1;  j <= i+nums[i] && j <= length; j++) {
                array[j] = Math.min(array[i]+1, array[j]);
            }
        }

        return array[length-1];
    }
}
