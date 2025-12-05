package com.ke.utopia.ailab;

/**
 * 类名：RotateImage
 * 描述：
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * 作者：zifengchen
 * 日期：2025/12/4
 */
public class RotateImage {

    public static void main(String[] args) {

        RotateImage rotateImage = new RotateImage();
        rotateImage.runTests();


    }


    public void rotate(int[][] matrix) {
        int length = matrix.length;

        int moveLen = length - 1;

        for (int i = 0; i < length/2; i++) {
            for (int j = i; j < length-1-i; j++) {

                int iTemp = i;
                int jTemp = j;
                int temp = matrix[iTemp][jTemp];
                int temp1 = 0;
                for (int k = 0; k < 4; k++) {
                    temp1 = matrix[jTemp][moveLen - iTemp];
                    matrix[jTemp][moveLen - iTemp] = temp;
                    temp = temp1;
                    int iT = iTemp;
                    iTemp = jTemp;
                    jTemp = moveLen - iT;
                }
            }
        }
    }


    public void runTests() {
        System.out.println("=== 图像旋转测试 ===");

        // 测试用例1: 3x3矩阵
        testCase1();

        // 测试用例2: 4x4矩阵
        testCase2();

        // 测试用例3: 1x1矩阵
        testCase3();

        // 测试用例4: 2x2矩阵
        testCase4();
    }

    private void testCase1() {
        System.out.println("\n测试用例1: 3x3矩阵");
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] expected = {{7,4,1},{8,5,2},{9,6,3}};

        System.out.println("原矩阵:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("旋转后:");
        printMatrix(matrix);

        System.out.println("期望结果:");
        printMatrix(expected);

        System.out.println("测试结果: " + (isEqual(matrix, expected) ? "✅ 通过" : "❌ 失败"));
    }

    private void testCase2() {
        System.out.println("\n测试用例2: 4x4矩阵");
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] expected = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};

        System.out.println("原矩阵:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("旋转后:");
        printMatrix(matrix);

        System.out.println("期望结果:");
        printMatrix(expected);

        System.out.println("测试结果: " + (isEqual(matrix, expected) ? "✅ 通过" : "❌ 失败"));
    }

    private void testCase3() {
        System.out.println("\n测试用例3: 1x1矩阵");
        int[][] matrix = {{1}};
        int[][] expected = {{1}};

        System.out.println("原矩阵:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("旋转后:");
        printMatrix(matrix);

        System.out.println("测试结果: " + (isEqual(matrix, expected) ? "✅ 通过" : "❌ 失败"));
    }

    private void testCase4() {
        System.out.println("\n测试用例4: 2x2矩阵");
        int[][] matrix = {{1,2},{3,4}};
        int[][] expected = {{3,1},{4,2}};

        System.out.println("原矩阵:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("旋转后:");
        printMatrix(matrix);

        System.out.println("期望结果:");
        printMatrix(expected);

        System.out.println("测试结果: " + (isEqual(matrix, expected) ? "✅ 通过" : "❌ 失败"));
    }

    /**
     * 打印矩阵
     */
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }

    /**
     * 比较两个矩阵是否相等
     */
    private boolean isEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) return false;

        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) return false;
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) return false;
            }
        }
        return true;
    }



}
