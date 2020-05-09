package com.bobby.peng.learning.java.algorithm;

public class ChessFromLu {

    private int chessLength = 5;
    private int[] used;

    public ChessFromLu(int chessLength) {
        this.chessLength = chessLength;
        used = new int[chessLength];
    }


    public int find(int deep) {
        if (deep == chessLength) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < chessLength; i++) {
            if (used[i] == 0 && deep + i != chessLength - 1) {
                used[i] = 1;
                result += find(deep + 1);
                used[i] = 0;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ":" + new ChessFromLu(i).find(0));
        }
    }

}
