package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * i < n + 1; j++) {
                if (arr[i * j]) {
                    continue;
                }

                arr[i * j] = true;
                k--;

                if (k == 0) {
                    System.out.println(i * j);
                    return;
                }
            }
        }
    }
}
