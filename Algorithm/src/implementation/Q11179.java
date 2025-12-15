package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = "";

        while (n > 0) {
            s += n % 2;
            n /= 2;
        }

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            sum += x * Math.pow(2, s.length() - i - 1);
        }

        System.out.println(sum);
    }
}
