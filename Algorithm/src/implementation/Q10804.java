package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20];

        for (int i = 1; i <= 20; i++) {
            arr[i - 1] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j <= (end - start) / 2; j++) {
                int tmp = arr[start + j];
                arr[start + j] = arr[end - j];
                arr[end - j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
