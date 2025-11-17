package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        int x = (int) Math.round(n * 0.15);
        long result = 0L;

        for (int i = x; i < n - x; i++) {
            result += array[i];
        }

        int avg = (int) Math.round((double) result / (n - (2 * x)));
        System.out.println(avg);
    }
}
