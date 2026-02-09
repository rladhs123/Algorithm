package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2581 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean isFind = true;
        boolean isFirst = true;
        int sum = 0;
        int min = 0;

        for (int i = m; i <= n; i++) {
            if (i < 2) {
                continue;
            }

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isFind = false;
                    break;
                }
            }

            if (isFind) {
                if (isFirst) {
                    min = i;
                    isFirst = false;
                }

                sum += i;
            }

            isFind = true;
        }

        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}
