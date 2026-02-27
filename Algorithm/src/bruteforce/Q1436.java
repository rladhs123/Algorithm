package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[1] = 666;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1];

            while (true) {
                if (arr[i] > arr[i - 1] && Integer.toString(arr[i]).contains("666")) {
                    break;
                }

                arr[i]++;
            }
        }

        System.out.println(arr[n]);
    }
}
