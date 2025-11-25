package com.ke.utopia.ailab;

/**
 * 类名：GasStation
 * 描述：
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * 作者：zifengchen
 * 日期：2025/11/24
 */
public class GasStation {


    public static void main(String[] args) {
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);


    }


    public static int canCompleteCircuit_1(int[] gas, int[] cost) {
        int length = gas.length;
        int[] array = new int[length];
        int sum = 0;
        int[] prefix = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = gas[i] - cost[i];
            sum += array[i];
            prefix[i] = sum;
        }
        // 抽象成从哪个节点开始环绕一圈，使加和不小于0
        if (sum < 0) {
            return -1;
        }

        int[] suffix = new int[length];
        sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum += array[i];
            suffix[i] = sum;
        }

        int start = 0;

        for (int i = 0; i < length; i++) {
            if (prefix[i] + suffix[(i + 1) & length] >= 0) {
                return i;
            }
        }
        return -1;

    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int length = gas.length;

        int i = 0;
        while (i < length) {
            int tempL = 0;
            int tempSum = 0;
            while (tempL < length) {

                int j = (i + tempL) % length;
                tempSum += gas[j] - cost[j];
                if (tempSum < 0) {
                    break;
                }
                tempL++;
            }
            if (tempL == length) {
                return i;
            } else {
                i = i + tempL + 1;
            }
        }
        return -1;

    }


    public static int canCompleteCircuit_2(int[] gas, int[] cost) {
        int totalTank = 0;    // 总油量差
        int currentTank = 0;  // 当前油量
        int startStation = 0; // 起始加油站

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currentTank += diff;

            // 如果当前油量不足，重新选择起始点
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        // 只有总油量非负才可能有解
        return totalTank >= 0 ? startStation : -1;
    }
}
