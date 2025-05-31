package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {

    static int[] array;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        array = new int[9];
        result = new int[7];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }


        dfs(0, 0, 0);

    }

    static void dfs(int depth, int index, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                Arrays.sort(result);
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < result.length; i++) {
                    sb.append(result[i]).append('\n');
                }

                System.out.print(sb);
                System.exit(0);
            }
            return;
        }

        for (int i = index; i < array.length; i++) {
            result[depth] = array[i];
            dfs(depth + 1, i + 1, sum + result[depth]);
        }
    }
}
