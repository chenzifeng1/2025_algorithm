package com.ke.utopia.ailab;

import java.util.HashSet;
import java.util.Set;

/**
 * 类名：HappyNumber
 * 描述：编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 作者：zifengchen
 * 日期：2025/12/5
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        // 测试用例1：示例1 - 快乐数
        System.out.println("=== 测试用例1：n = 19 ===");
        int n1 = 19;
        System.out.println("输入：" + n1);
        System.out.println("方法1结果：" + solution.isHappy(n1));
        System.out.println("期望：true");
        System.out.println("计算过程：1² + 9² = 82, 8² + 2² = 68, 6² + 8² = 100, 1² + 0² + 0² = 1\n");

        // 测试用例2：示例2 - 非快乐数
        System.out.println("=== 测试用例2：n = 2 ===");
        int n2 = 2;
        System.out.println("输入：" + n2);
        System.out.println("方法1结果：" + solution.isHappy(n2));
        System.out.println("期望：false\n");

        // 测试用例3：边界情况 - 1
        System.out.println("=== 测试用例3：n = 1 ===");
        int n3 = 1;
        System.out.println("输入：" + n3);
        System.out.println("结果：" + solution.isHappy(n3));
        System.out.println("期望：true\n");

        // 测试用例4：单位数快乐数
        System.out.println("=== 测试用例4：n = 7 ===");
        int n4 = 7;
        System.out.println("输入：" + n4);
        System.out.println("结果：" + solution.isHappy(n4));
        System.out.println("期望：true");
        System.out.println("计算过程：7² = 49, 4² + 9² = 97, 9² + 7² = 130, 1² + 3² + 0² = 10, 1² + 0² = 1\n");

        // 测试用例5：大数
        System.out.println("=== 测试用例5：n = 100 ===");
        int n5 = 100;
        System.out.println("输入：" + n5);
        System.out.println("结果：" + solution.isHappy(n5));
        System.out.println("期望：true");
        System.out.println("计算过程：1² + 0² + 0² = 1\n");

        // 测试用例6：会进入循环的数
        System.out.println("=== 测试用例6：n = 4 ===");
        int n6 = 4;
        System.out.println("输入：" + n6);
        System.out.println("结果：" + solution.isHappy(n6));
        System.out.println("期望：false");
        System.out.println("会进入循环：4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4\n");

        // 测试用例7：其他快乐数
        System.out.println("=== 测试用例7：其他快乐数 ===");
        int[] happyNumbers = {1, 7, 10, 13, 19, 23, 28, 31};
        System.out.print("快乐数测试：");
        for (int num : happyNumbers) {
            System.out.print(num + ":" + solution.isHappy(num) + " ");
        }
        System.out.println("\n期望：全部为true\n");
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        int time = 0;
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int temp = 0;
            while (n > 0) {
                int y = n % 10;
                temp += y * y;
                n /= 10;
            }
            n = temp;

        }

        return n==1;

    }

}
