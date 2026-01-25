package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            int x = a * (b.charAt(b.length() - i - 1) - '0');
            sum += x * Math.pow(10, i);
            System.out.println(x);
        }

        System.out.println(sum);
    }
}
