package vreshetnyak;

/**
 *
 * @author Василий
 */
public class Main {

    private static boolean[] color;
    private static int[][] map;

    /**
     * @param args the command line arguments
     * Точка входа
     */
    public static void main(String[] args) {
        byte map[][] = {
            {0, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0, 0},};
        searchOne(map);

    }
    
    /**
     * Поиск единиц
     * @param m 
     */
    static void searchOne(byte m[][]) {
        for (byte[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[j] != 0) {
                    System.out.println("1");
                }
            }
        }
    }
}
