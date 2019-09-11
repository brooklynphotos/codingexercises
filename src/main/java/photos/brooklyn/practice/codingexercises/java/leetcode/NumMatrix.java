package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {
    private final int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        sumMatrix = makeSumMatrix(matrix);
    }

    static int[][] makeSumMatrix(int[][] matrix) {
        final int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int row = 0; row < sumMatrix.length; row++) {
            for (int col = 0; col < sumMatrix[row].length; col++) {
                if (row > 0 && col > 0) {
                    sumMatrix[row][col] = sumMatrix[row][col - 1] + (row>1 ? matrix[row - 2][col - 1] : 0) + matrix[row - 1][col - 1];
                }
            }
        }
        return sumMatrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 1;
    }

    public static void main(String[] args) {
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
        };
        NumMatrix obj = new NumMatrix(matrix);
        final int row1 = Integer.parseInt(args[0]);
        final int col1 = Integer.parseInt(args[1]);
        final int row2 = Integer.parseInt(args[2]);
        final int col2 = Integer.parseInt(args[3]);
        int param_1 = obj.sumRegion(row1, col1, row2, col2);
        System.out.println(param_1);
    }
}
