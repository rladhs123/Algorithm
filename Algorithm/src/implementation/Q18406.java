package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        String s1 = input.substring(0, length / 2);
        String s2 = input.substring(length / 2, length);
        int sum = 0;

        for (int i = 0; i < length / 2; i++) {
            sum += s1.charAt(i) - s2.charAt(i);
        }

        if (sum == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
