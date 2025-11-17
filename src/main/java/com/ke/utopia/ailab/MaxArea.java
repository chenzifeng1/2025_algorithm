package com.ke.utopia.ailab;

/**
 * 类名：MaxArea
 * 描述：
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 作者：zifengchen
 * 日期：2025/11/17
 */
public class MaxArea {


    public static void main(String[] args) {
        int[] arrays = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea1(arrays);
        System.out.println(result);

    }

    public static int maxArea(int[] height) {
        int left =0,right =0;
        int maxArea = 0;
        int length = height.length;
        while (left < length) {
            for (right = left+1; right <length;right++) {
                int tempArea = Math.min(height[left], height[right]) * (right - left);
                if (maxArea<= tempArea) {
                    maxArea =tempArea;
                }
            }
            left++;
        }

        return maxArea;
    }

    public static int maxArea1(int[] height){
        int left =0, right=height.length-1;
        int maxArea = 0;

        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right-left);
            if (maxArea<=tempArea) {
                maxArea=tempArea;
            }
            if (height[left]>height[right]) {
                right--;
            }else {
                left++;
            }
        }

        return maxArea;

    }

}
