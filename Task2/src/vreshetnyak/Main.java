package vreshetnyak;

import java.util.Stack;

/**
 *
 * @author Василий
 */
public class Main {

    private static boolean[][] color;
    private static byte[][] map = {
        {0, 0, 0, 0, 1, 1},
        {0, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 1, 1, 0, 1},
        {0, 0, 1, 0, 0, 1}};

    /**
     * @param args the command line arguments Точка входа
     */
    public static void main(String[] args) {
        searchOne(map);
//        int k = 0;
//        for (boolean[] col : color) {
//            for (int j = 0; j < col.length; j++) {
//                if(col[j]){
//                    System.out.println(true);
//                }               
//            }
//            k++;
//        }
    }

    /**
     * Поиск единиц
     *
     * @param m
     */
    static void searchOne(byte m[][]) {
        color = new boolean[m.length][m.length];

        int k = 0;
        for (byte[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[j] == 1) {
                    System.out.println("Input [" + k + "][" + j + "]");
                    dfs(k, j);
                    color[k][j] = true;
                }
            }
            k++;
        }
    }

    /**
     *
     * @param k
     * @param j
     */
    static void dfs(int k, int j) {
        /*
         k - 1; j 12 
         k; j + 1 3
         k + 1; j 6
         k; j - 1 9
         k - columns
         j - line
         */

        /**
         * 3 hours
         */
        if (j + 1 <= map[j].length - 1) {
            if (map[k][j + 1] == 1) {
                System.out.println("Step [" + k + "][" + (j + 1) + "] - right");
                map[k][j] = 0;
                printDeletedPoint(k, j);
                dfs(k, j);
            } else {
                dfs(k, j - 1);
            }
        }
        /**
         * 6 hours
         */
        if (k + 1 <= map.length - 1) {
            if (map[k + 1][j] == 1) {
                System.out.println("Step [" + (k + 1) + "][" + j + "] - bottom");
                map[k][j] = 0;
                printDeletedPoint(k, j);
                dfs(k, j);
            } else {
                dfs(k - 1, j);
            }
        }
        /**
         * 9 hours
         */
        if (j - 1 >= 0) {
            if (map[k][j - 1] == 1) {
                System.out.println("Step [" + k + "][" + (j - 1) + "] - left");
                map[k][j] = 0;
                printDeletedPoint(k, j);
                dfs(k, j - 1);
            }
        }
        /**
         * 12 hours
         */
        if (k - 1 >= 0) {
            if (map[k - 1][j] == 1) {
                System.out.println("Step [" + (k - 1) + "][" + j + "] - top");
                map[k][j] = 0;
                printDeletedPoint(k, j);
                dfs(k - 1, j);
            }
        }
    }

    static void printDeletedPoint(int k, int j) {
        System.out.println("Deleted point [" + k + "][" + j + "]");
    }
}
