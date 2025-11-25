package com.ke.utopia.ailab;

import java.util.Arrays;

/**
 * 类名：ProductOfArrayExceptSelf
 * 描述：给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 输入 保证 数组 answer[i] 在  32 位 整数范围内
 * 作者：zifengchen
 * 日期：2025/11/24
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4};

        int[] ints = productExceptSelf(array);
        System.out.println(Arrays.toString(ints));


    }


    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;


        int[] prefixArray = new int[length ];
        int[] suffixArray = new int[length ];

        int temp = 1;

        for (int i = 0; i < length; i++) {
             temp *= nums[i];
            prefixArray[i] =temp;
        }
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            suffixArray[i] = temp *= nums[i];
        }

        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
           if (i == 0) {
               answer[i] = suffixArray[i+1];
               continue;
           }else if (i == length-1) {
               answer[i] = prefixArray[i-1];
               continue;
           }
            answer[i] = suffixArray[i+1] * prefixArray[i-1];

        }

        return answer;
    }

}
