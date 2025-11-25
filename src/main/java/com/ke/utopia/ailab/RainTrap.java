package com.ke.utopia.ailab;

/**
 * 类名：RainTrap
 * 描述：
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * 作者：zifengchen
 * 日期：2025/11/17
 */
public class RainTrap {


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int trap = dynamicProgrammingTrap(nums);
        System.out.println(trap);


    }


    public static int trap(int[] height) {

        int maxHeightPos = -1;
        int maxHeight = 0;

        for (int i = 0; i < height.length; i++) {
            if (maxHeight <= height[i]) {
                maxHeight = height[i];
                maxHeightPos = i;
            }
        }
        if (maxHeightPos == -1) {
            return 0;
        }

        int waterHeight = 0;
        int waterSum = 0;

        for (int i = 0; i < maxHeightPos; i++) {
            if (waterHeight < height[i]) {
                waterHeight = height[i];
            }
            waterSum += waterHeight - height[i];
        }

        waterHeight = 0;
        for (int i = height.length - 1; i > maxHeightPos; i--) {
            if (waterHeight < height[i]) {
                waterHeight = height[i];
            }
            waterSum += waterHeight - height[i];
        }
        return waterSum;
    }

    /**
     * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
     * <p>
     * 朴素的做法是对于数组 height 中的每个元素，分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。假设数组 height 的长度为 n，该做法需要对每个下标位置使用 O(n) 的时间向两边扫描并得到最大高度，因此总时间复杂度是 O(n
     * 2
     * )。
     * <p>
     * 上述做法的时间复杂度较高是因为需要对每个下标位置都向两边扫描。如果已经知道每个位置两边的最大高度，则可以在 O(n) 的时间内得到能接的雨水总量。使用动态规划的方法，可以在 O(n) 的时间内预处理得到每个位置两边的最大高度。
     * <p>
     * 创建两个长度为 n 的数组 leftMax 和 rightMax。对于 0≤i<n，leftMax[i] 表示下标 i 及其左边的位置中，height 的最大高度，rightMax[i] 表示下标 i 及其右边的位置中，height 的最大高度。
     * <p>
     * 显然，leftMax[0]=height[0]，rightMax[n−1]=height[n−1]。两个数组的其余元素的计算如下：
     * <p>
     * 当 1≤i≤n−1 时，leftMax[i]=max(leftMax[i−1],height[i])；
     * <p>
     * 当 0≤i≤n−2 时，rightMax[i]=max(rightMax[i+1],height[i])。
     * <p>
     * 因此可以正向遍历数组 height 得到数组 leftMax 的每个元素值，反向遍历数组 height 得到数组 rightMax 的每个元素值。
     * <p>
     * 在得到数组 leftMax 和 rightMax 的每个元素值之后，对于 0≤i<n，下标 i 处能接的雨水量等于 min(leftMax[i],rightMax[i])−height[i]。遍历每个下标位置即可得到能接的雨水总量。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public static int dynamicProgrammingTrap(int[] height) {
        int n = height.length;
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];

        if (n <= 2) {
            return 0;
        }


        leftMaxHeight[1] = height[0];

        for (int i = 2; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i - 1]);
        }

        rightMaxHeight[n - 2] = height[n - 1];

        for (int i = n - 3; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }

        int sum = 0;


        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.max((Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i]), 0);
        }

        return sum;
    }


}
