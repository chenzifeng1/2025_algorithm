package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.PriorityQueue;

/**
 * 类名：MaxSlidingWindow
 * 描述：
 * 、给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * 作者：zifengchen
 * 日期：2025/11/19
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = new int[]{-7,-8,7,5,7,1,6,0};
        int k = 4;
        int[] answer = maxSlidingWindow(nums, k);
        for (int i : answer) {
            System.out.println(i);
        }

    }


    /**
     * TIME OUT
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> resultList = new ArrayList<>();

        int length = nums.length;
        int[] tempArray = new int[k];

        int tempMax = Integer.MIN_VALUE;
        int tempMaxPos = 0;
        if (k == 1) {
            return nums;
        }


        for (int i = 0; i < k; i++) {
            tempArray[i] = nums[i];
            if (tempMax < tempArray[i]) {
                tempMax = tempArray[i];
                tempMaxPos = i;
            }
        }

        resultList.add(tempMax);

        int kUpdateIndex = 0;
        for (int i = 0; i < length - k; i++) {
            int intoNum = nums[i + k];
            tempArray[(kUpdateIndex++) % k] = intoNum;
            if (tempMax <= intoNum) {
                tempMax = intoNum;
                tempMaxPos = i + k;
            }
            if (tempMaxPos <= i) {
                // 触发重新排序
                tempMax = Integer.MIN_VALUE;
                for (int j = i + 1; j <= i + k; j++) {
                    if (tempMax < nums[j]) {
                        tempMax = nums[j];
                        tempMaxPos = j;
                    }
                }
            }


            resultList.add(tempMax);
        }


        return resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    /**
     * 使用堆去解决问题
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1) {
            return nums;
        }

        int length = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0] == 0 ? o2[1] - o1[1] : o2[0] - o1[0];
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        // 先将前k个元素放入堆中
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        List<Integer> result = new ArrayList<>();
        result.add(pq.peek()[0]);
        for (int i = k; i < length; i++) {

            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i-k) {
                pq.poll();
            }
            result.add(pq.peek()[0]);
        }
        return result.stream().mapToInt(v->v).toArray();
    }


}
