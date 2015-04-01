package vreshetnyak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Василий
 */
public class Main {

    private static int[][] workingArray;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите количество строк массива:");
        int lines = Integer.parseInt(reader.readLine());

        System.out.println("Введите количество столбцов массива:");
        int columns = Integer.parseInt(reader.readLine());

        System.out.println("Введите искомое значение:");
        int required = Integer.parseInt(reader.readLine());

        /**
         *
         * Метод для заполнения массива
         */
        buildArray(lines, columns);

        /**
         *
         * Метод поиска индекса заданного значения на совпадение в массиве
         */
        searchNumberInArray(workingArray, required, lines, columns);

    }

    private static void buildArray(int m, int n) {
        workingArray = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                workingArray[i][j] = k;
                k++;
            }
        }
    }

    private static void searchNumberInArray(int[][] workingArray, int required, int lines, int columns) {

        if (workingArray[0][0] > required | workingArray[lines - 1][columns - 1] < required) {
            System.out.println("Искомого значения в массиве нет!");
        } else if (workingArray[0][0] == required) {
            System.out.println("Индекс искомого значения: [0][0]");
        } else {
            if (workingArray[0][columns - 1] > required) {
                for (int i = 0; i < columns; i++) {
                    if (workingArray[0][i] == required) {
                        System.out.println("Индекс искомого значения: [0][" + i + "]");
                        break;
                    }
                }
            } else {
                for (int i = 1; i < lines; i++) {
                    if (workingArray[i][columns - 1] > required) {
                        for (int k = 0; k < lines; k++) {
                            if (workingArray[i][k] == required) {
                                System.out.println("Индекс искомого значения: [" + i + "][" + k + "]");
                                break;
                            }
                        }
                    } else if (workingArray[i][columns - 1] == required) {
                        System.out.println("Индекс искомого значения: [" + i + "][" + (columns - 1) + "]");
                    }
                }
            }
        }
    }

}
