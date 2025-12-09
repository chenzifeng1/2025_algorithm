package com.ke.utopia.ailab;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类名：KthLargestElementInAnArray
 * 描述：给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 作者：zifengchen
 * 日期：2025/12/5
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();

        // 测试用例1
        System.out.println("=== 测试用例1 ===");
        int[] nums1 = {3,2,1,5,6,4};
        int k1 = 2;
        System.out.println("输入：nums = [3,2,1,5,6,4], k = 2");
        System.out.println("方法1结果：" + solution.findKthLargest(nums1, k1));

        System.out.println("期望：5\n");

        // 测试用例2
        System.out.println("=== 测试用例2 ===");
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        System.out.println("输入：nums = [3,2,3,1,2,4,5,5,6], k = 4");
        System.out.println("方法1结果：" + solution.findKthLargest(nums2, k2));

        System.out.println("期望：4\n");

        // 测试用例3：单个元素
        System.out.println("=== 测试用例3：单个元素 ===");
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("输入：nums = [1], k = 1");
        System.out.println("结果：" + solution.findKthLargest(nums3, k3));
        System.out.println("期望：1\n");

        // 测试用例4：相同元素
        System.out.println("=== 测试用例4：相同元素 ===");
        int[] nums4 = {1,1,1,1,1};
        int k4 = 3;
        System.out.println("输入：nums = [1,1,1,1,1], k = 3");
        System.out.println("结果：" + solution.findKthLargest(nums4, k4));
        System.out.println("期望：1\n");

        // 测试用例5：负数
        System.out.println("=== 测试用例5：负数 ===");
        int[] nums5 = {-1,2,0};
        int k5 = 1;
        System.out.println("输入：nums = [-1,2,0], k = 1");
        System.out.println("结果：" + solution.findKthLargest(nums5, k5));
        System.out.println("期望：2\n");
    }


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> stack = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            stack.offer(nums[i]);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = stack.poll();
        }

        return result;
    }
}
