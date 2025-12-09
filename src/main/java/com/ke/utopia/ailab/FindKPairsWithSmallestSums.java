package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 类名：FindKPairsWithSmallestSums
 * 描述：给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 和 nums2 均为 升序排列
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 * 作者：zifengchen
 * 日期：2025/12/5
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        FindKPairsWithSmallestSums solution = new FindKPairsWithSmallestSums();

        System.out.println("=== 测试 kSmallestPairs_1 方法 ===\n");

        // 测试用例1：基本示例
        System.out.println("=== 测试用例1：基本示例 ===");
        int[] nums1_1 = {1,2,4,5,6};
        int[] nums2_1 = {3,5,7,9};
        int k1 = 20;
        System.out.println("输入：nums1 = " + Arrays.toString(nums1_1) +
                ", nums2 = " + Arrays.toString(nums2_1) + ", k = " + k1);
        try {
            List<List<Integer>> result1 = solution.kSmallestPairs_1(nums1_1, nums2_1, k1);
            System.out.println("kSmallestPairs_1结果：" + result1);
            System.out.println("正确答案：[[1,3],[2,3],[1,5],[2,5],[4,3],[1,7],[5,3],[2,7],[4,5],[6,3],[1,9],[5,5],[2,9],[4,7],[6,5],[5,7],[4,9],[6,7],[5,9],[6,9]]");
        } catch (Exception e) {
            System.out.println("❌ 异常：" + e.getMessage());
        }
        System.out.println();

        // 测试用例2：会导致越界的情况
        System.out.println("=== 测试用例2：数组长度不同 ===");
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4, 5, 6};
        int k2 = 3;
        System.out.println("输入：nums1 = " + Arrays.toString(nums1_2) +
                ", nums2 = " + Arrays.toString(nums2_2) + ", k = " + k2);
        try {
            List<List<Integer>> result2 = solution.kSmallestPairs_1(nums1_2, nums2_2, k2);
            System.out.println("kSmallestPairs_1结果：" + result2);
            System.out.println("正确答案：[[1,3],[1,4],[2,3]]");
        } catch (Exception e) {
            System.out.println("❌ 异常：" + e.getMessage());
        }
        System.out.println();

        // 测试用例3：k=1的边界情况
        System.out.println("=== 测试用例3：k=1 ===");
        int[] nums1_3 = {1, 3, 5};
        int[] nums2_3 = {2, 4, 6};
        int k3 = 1;
        System.out.println("输入：nums1 = " + Arrays.toString(nums1_3) +
                ", nums2 = " + Arrays.toString(nums2_3) + ", k = " + k3);
        try {
            List<List<Integer>> result3 = solution.kSmallestPairs_1(nums1_3, nums2_3, k3);
            System.out.println("kSmallestPairs_1结果：" + result3);
            System.out.println("正确答案：[[1,2]]");
        } catch (Exception e) {
            System.out.println("❌ 异常：" + e.getMessage());
        }
        System.out.println();

        // 测试用例4：单元素数组
        System.out.println("=== 测试用例4：单元素数组 ===");
        int[] nums1_4 = {1};
        int[] nums2_4 = {1};
        int k4 = 1;
        System.out.println("输入：nums1 = " + Arrays.toString(nums1_4) +
                ", nums2 = " + Arrays.toString(nums2_4) + ", k = " + k4);
        try {
            List<List<Integer>> result4 = solution.kSmallestPairs_1(nums1_4, nums2_4, k4);
            System.out.println("kSmallestPairs_1结果：" + result4);
            System.out.println("正确答案：[[1,1]]");
        } catch (Exception e) {
            System.out.println("❌ 异常：" + e.getMessage());
        }
        System.out.println();

        // 测试用例5：会无限循环的情况
        System.out.println("=== 测试用例5：大k值 ===");
        int[] nums1_5 = {1, 2};
        int[] nums2_5 = {3, 4};
        int k5 = 4;
        System.out.println("输入：nums1 = " + Arrays.toString(nums1_5) +
                ", nums2 = " + Arrays.toString(nums2_5) + ", k = " + k5);
        try {
            List<List<Integer>> result5 = solution.kSmallestPairs_1(nums1_5, nums2_5, k5);
            System.out.println("kSmallestPairs_1结果：" + result5);
            System.out.println("正确答案：[[1,3],[1,4],[2,3],[2,4]]");
        } catch (Exception e) {
            System.out.println("❌ 异常：" + e.getMessage());
        }
        System.out.println();


    }


    /**
     * OOM
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });


        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.offer(new int[]{nums1[i], nums2[j]});
            }
        }

        List<List<Integer>> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            result.add(Arrays.asList(poll[0], poll[1]));
        }

        return result;
    }

    public List<List<Integer>> kSmallestPairs_1(int[] nums1, int[] nums2, int k) {

        int index = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length2 == 0 || length1 == 0 || k == 0) {
            return new ArrayList<>();
        }


        List<List<Integer>> result = new ArrayList<>(k);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(o->o[0]));

        for (int i = 0; i < length1; i++) {
            priorityQueue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        boolean[] isAdd = new boolean[length1];


        while (result.size() < k && !priorityQueue.isEmpty()) {

            int[] poll = priorityQueue.poll();
            int i = poll[1];
            int j = poll[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < length2 ) {
                priorityQueue.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }


        }
        return result;

    }


}
