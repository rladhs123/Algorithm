package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                sum += (c - '0') * Math.pow(16, s.length() - 1 - i);
            } else {
                sum += (c - 'A' + 10) * Math.pow(16, s.length() - 1 - i);
            }
        }

        System.out.println(sum);
    }
}
