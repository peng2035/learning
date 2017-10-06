package com.bobby.peng.learning.leetcode;

import java.util.*;

/**
 * Created by bobby.peng on 2017/9/22.
 */
public class BrickWall {

    class Index {
        Index(int offset, int index) {
            this.offset = offset;
            this.index = index;
        }

        int offset;
        int index;
    }

    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        Index[] indexes = new Index[height];

        int nullNum = 0;
        for (int i = 0; i < wall.size(); i++) {
            if(wall.get(i).size() == 1) {
                nullNum++;
                continue;
            }
            indexes[i] = new Index(0, 0);
        }

        int min = height;
        List<Integer> wall0 = wall.get(0);
        for (int i = 0; i < wall0.size(); i++) {
            int value = wall0.get(i);
            for (int j = 0; j < value; j++) {
                if (i == wall0.size() - 1 && j == value - 1)
                    break;//end

                int minTemp = 0;

                for (int m = 0; m < height; m++) {
                    Index index = indexes[m];

                    if (index == null) {
                        minTemp++;
                        continue;
                    }

                    if (index.index == wall.get(m).size() - 1) {
                        minTemp++;
                        indexes[m] = null;
                        nullNum++;
                        continue;
                    }

                    if (index.offset == wall.get(m).get(index.index) - 1) {
                        index.offset = 0;
                        index.index++;
                    } else {
                        index.offset++;
                        minTemp++;
                    }
                }
                if (minTemp < min) {
                    min = minTemp;
                }
                if(nullNum == height) {
                    return min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1, 2, 2, 1));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 2));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 1, 1));

        BrickWall brickWall = new BrickWall();
        System.out.println(brickWall.leastBricks(list));
    }

}
