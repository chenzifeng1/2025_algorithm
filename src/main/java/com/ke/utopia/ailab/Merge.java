package com.ke.utopia.ailab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 类名：Merge
 * 描述：
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 * <p>
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 作者：zifengchen
 * 日期：2025/11/19
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();


        int[][] intervals0 = {{1, 4}, {0, 2}, {3, 5}};
        int[][] merge0 = merge.merge(intervals0);
        System.out.println(Arrays.deepToString(merge0));


        // 测试用例1：示例1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("测试用例1：");
        System.out.println("输入：" + Arrays.deepToString(intervals1));
        int[][] result1 = merge.merge(intervals1);
        System.out.println("输出：" + Arrays.deepToString(result1));
        System.out.println("期望：[[1,6],[8,10],[15,18]]");
        System.out.println();

        // 测试用例2：示例2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("测试用例2：");
        System.out.println("输入：" + Arrays.deepToString(intervals2));
        int[][] result2 = merge.merge(intervals2);
        System.out.println("输出：" + Arrays.deepToString(result2));
        System.out.println("期望：[[1,5]]");
        System.out.println();

        // 测试用例3：示例3
        int[][] intervals3 = {{4, 7}, {1, 4}};
        System.out.println("测试用例3：");
        System.out.println("输入：" + Arrays.deepToString(intervals3));
        int[][] result3 = merge.merge(intervals3);
        System.out.println("输出：" + Arrays.deepToString(result3));
        System.out.println("期望：[[1,7]]");
        System.out.println();

        // 测试用例4：单个区间
        int[][] intervals4 = {{1, 4}};
        System.out.println("测试用例4（单个区间）：");
        System.out.println("输入：" + Arrays.deepToString(intervals4));
        int[][] result4 = merge.merge(intervals4);
        System.out.println("输出：" + Arrays.deepToString(result4));
        System.out.println("期望：[[1,4]]");
        System.out.println();

        // 测试用例5：无重叠区间
        int[][] intervals5 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println("测试用例5（无重叠）：");
        System.out.println("输入：" + Arrays.deepToString(intervals5));
        int[][] result5 = merge.merge(intervals5);
        System.out.println("输出：" + Arrays.deepToString(result5));
        System.out.println("期望：[[1,2],[3,4],[5,6]]");
        System.out.println();

        // 测试用例6：完全重叠
        int[][] intervals6 = {{1, 4}, {2, 3}};
        System.out.println("测试用例6（完全重叠）：");
        System.out.println("输入：" + Arrays.deepToString(intervals6));
        int[][] result6 = merge.merge(intervals6);
        System.out.println("输出：" + Arrays.deepToString(result6));
        System.out.println("期望：[[1,4]]");
        System.out.println();

        // 测试用例7：多个连续重叠
        int[][] intervals7 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {16, 20}};
        System.out.println("测试用例7（多个连续重叠）：");
        System.out.println("输入：" + Arrays.deepToString(intervals7));
        int[][] result7 = merge.merge(intervals7);
        System.out.println("输出：" + Arrays.deepToString(result7));
        System.out.println("期望：[[1,6],[8,10],[15,20]]");
    }


    public int[][] merge(int[][] intervals) {
        int length = intervals.length;

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);

        List<int[]> array = new ArrayList<>();

        int tempLeft = intervals[0][0];
        int tempRight = intervals[0][1];
        for (int i = 0; i < length - 1; i++) {

            if (intervals[i + 1][0] <= tempRight) {
                // 可以合并
                tempRight = Math.max(tempRight, intervals[i + 1][1]);
                tempLeft = Math.min(tempLeft, intervals[i + 1][0]);
            } else {
                // 合并不了
                array.add(new int[]{tempLeft, tempRight});
                tempLeft = intervals[i + 1][0];
                tempRight = intervals[i + 1][1];
            }
        }

        // 处理最后一块
        if (intervals[length - 1][0] <= tempRight) {
            // 可以合并
            tempRight = Math.max(tempRight, intervals[length - 1][1]);
            tempLeft = Math.min(tempLeft, intervals[length - 1][0]);
            array.add(new int[]{tempLeft, tempRight});
        } else {
            // 合并不了
            array.add(new int[]{tempLeft, tempRight});
            array.add(intervals[length - 1]);
        }


        return array.toArray(new int[array.size()][]);
    }

}
