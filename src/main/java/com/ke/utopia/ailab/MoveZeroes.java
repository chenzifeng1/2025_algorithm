package com.ke.utopia.ailab;

/**
 * 类名：MoveZeroes
 * 描述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 作者：zifengchen
 * 日期：2025/11/17
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 1};
        moveZeroes1(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void moveZeroes(int[] nums) {

        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] == 0) {
                while (nums[j] == 0 && i < j) {
                    j--;
                }
                ;
                for (int ti = i; ti < j; ti++) {
                    int temp = nums[ti + 1];
                    nums[ti + 1] = nums[ti];
                    nums[ti] = temp;
                }
                if (nums[i] != 0) {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    /**
     * 左指针左边为非0数
     * 右指针左边到左指针右边都是0
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != 0 ) {
                swap(nums, left,right);
                left++;
            }
            right++;
        }

    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
