package com.bobby.peng.learning.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int[][] result = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(i!=0 && j!=0) {
                    result[i][j] = (result[i-1][j] < result[i][j-1] ? result[i-1][j] : result[i][j-1]) + grid[i][j];
                } else if(i==0 && j!=0) {
                    result[i][j] = result[i][j-1] + grid[i][j];
                } else if(j==0 && i!=0) {
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else {
                    result[i][j]=grid[i][j];
                }
            }
        }

        return result[grid.length-1][grid[0].length-1];

    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{3,4,5}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        minimumPathSum.minPathSum(grid);
    }


}
