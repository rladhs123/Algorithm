package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int sum = 0;
        boolean isOdd = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') {
                isOdd = i % 2 == 1;
                continue;
            }

            int x = input.charAt(i) - '0';

            if (i % 2 == 0) {
                sum += x;
            } else {
                sum += 3 * x;
            }
        }

        for (int i = 0; i < 10; i++) {
            int x = sum;

            if (isOdd) {
                x += 3 * i;
            } else {
                x += i;
            }

            if (x % 10 == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
