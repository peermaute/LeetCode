package medium;

public class MaxIncreaseToKeepCitySkyline_807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int i = getBiggestNumber(grid, row, col);
                if (i > grid[row][col]) {
                    result += i - grid[row][col];
                }
            }
        }
        return result;
    }

    private int getBiggestNumber(int[][] grid, int row, int col) {
        int resultRow = 0;
        int resultCol = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] > resultRow) {
                resultRow = grid[row][i];
            }
            if (grid[i][col] > resultCol) {
                resultCol = grid[i][col];
            }
        }
        if (resultRow > resultCol) {
            return resultCol;
        }
        return resultRow;
    }
}
