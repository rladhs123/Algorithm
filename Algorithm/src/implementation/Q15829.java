package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15829 {

    static long M = 1234567891;
    static long R = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
            long x = s.charAt(i) - 'a' + 1;
            sum = (sum + x * pow) % M;
            pow = (pow * R) % M;
        }

        System.out.println(sum);
    }
}
