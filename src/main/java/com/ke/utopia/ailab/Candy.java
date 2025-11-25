package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * 类名：Candy
 * 描述：
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 * 作者：zifengchen
 * 日期：2025/11/24
 */
public class Candy {

    public static void main(String[] args) {
        int[] array = new int[]{1,0,2,4,2};
        int candy = candy(array);
        System.out.println(candy);
    }

    public static int candy(int[] ratings) {

        int length = ratings.length;

        int[] candies = new int[length];

        Arrays.fill(candies, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] +1);
            }
        }

        return Arrays.stream(candies).sum();
    }
}
