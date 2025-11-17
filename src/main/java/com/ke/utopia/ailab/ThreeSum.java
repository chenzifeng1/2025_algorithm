package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：ThreeSum
 * 描述：
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 作者：zifengchen
 * 日期：2025/11/17
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        List<List<Integer>> r = threeSum(nums);
        System.out.println(r);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 先排序，然后两头取
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && (nums[first] == nums[first - 1])) {
                continue;
            }

            int left = first + 1, right = len - 1;
            int target = -nums[first];
            while (left < right) {
                // 将三数之和转换为两数之和
                if (nums[left] + nums[right] == target) {
                    // 找到了， 但是可能还有
                    result.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left]==nums[left-1]) left++;
                    while (right > left && nums[right]==nums[right+1]) right--;

                } else if (nums[left] + nums[right] < target) {
                    // 说明不够
                    left++;
                } else {
                    // 说明多了
                    right--;
                }
            }
        }

        return result;
    }
}
