package com.ke.utopia.ailab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 类名：LongestConsecutive
 * 描述：
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * <p>
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 作者：zifengchen
 * 日期：2025/11/14
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] num = new int[]{};

        int i = longestConsecutive1(num);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {

        List<Integer> collect = Arrays.stream(nums)
                .distinct()
                .sorted()
                .boxed()
                .toList();
        int maxLength = 0;
        for (int i = 0; i < collect.size(); i++) {
            int tempLength = 1;
            for (int j = i + 1; j < collect.size(); j++) {
                if (collect.get(j) - collect.get(i) == 1) {
                    i++;
                    tempLength++;
                } else {
                    i = j - 1;
                    break;
                }
            }
            if (maxLength <= tempLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }


    public static int longestConsecutive1(int[] nums) {
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }
        List<Integer> list = Arrays.stream(nums).distinct().boxed().toList();
        for (int i = 0; i < list.size(); i++) {
            int len = 1;
            if (map.containsKey(list.get(i)-1)) {
                continue;
            }
            for (int j = 1; map.containsKey(list.get(i) + j) && j <list.size(); j++) {
                len++;
            }
            if (maxLength <= len) {
                maxLength = len;
            }
        }
        return maxLength;
    }
}
