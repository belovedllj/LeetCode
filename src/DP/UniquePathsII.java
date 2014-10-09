package DP;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // num of rows
        int n = obstacleGrid[0].length; // num of columns
        int[] pathesCounter = new int[n];
        pathesCounter[0] = 1; // for [x][0] only one path
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (j == 0) continue; //mantain the same path number [[1][0]]
                    else pathesCounter[j] += pathesCounter[j - 1]; //add path number
                }
                else {
                    pathesCounter[j] = 0; //no path to here
                }
            }
        }
        return pathesCounter[n - 1];
    }
}
