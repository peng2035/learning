package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/10.
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int totalNum = 0;

        int diff = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    totalNum++;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        diff++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        diff++;
                    }
                }
            }
        }
        return totalNum * 4 - diff * 2;
    }

}
