package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int x = 1;

        while (x < input) {
            int sum = x;
            String value = Integer.toString(x);

            for (int i = 0; i < value.length(); i++) {
                sum += value.charAt(i) - '0';
            }

            if (sum == input) {
                break;
            }

            x++;
        }

        if (x < input) {
            System.out.println(x);
        } else {
            System.out.println(0);
        }
    }
}
