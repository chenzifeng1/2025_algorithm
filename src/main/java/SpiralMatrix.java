import java.util.ArrayList;
import java.util.List;

/**
 * 类名：SpiralMatrix
 * 描述：给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 作者：zifengchen
 * 日期：2025/12/4
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        // 测试用例1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("测试用例1: " + solution.spiralOrder(matrix1));
        // 期望输出: [1,2,3,6,9,8,7,4,5]

        // 测试用例2
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("测试用例2: " + solution.spiralOrder(matrix2));
        // 期望输出: [1,2,3,4,8,12,11,10,9,5,6,7]

        // 测试用例3：单行
        int[][] matrix3 = {{1,2,3,4}};
        System.out.println("测试用例3: " + solution.spiralOrder(matrix3));
        // 期望输出: [1,2,3,4]

        // 测试用例4：单列
        int[][] matrix4 = {{1},{2},{3}};
        System.out.println("测试用例4: " + solution.spiralOrder(matrix4));
        // 期望输出: [1,2,3]
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int bottom = matrix.length - 1;
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (bottom>=top) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left<=right) {
                for (int i = bottom; i >= top ; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

}
