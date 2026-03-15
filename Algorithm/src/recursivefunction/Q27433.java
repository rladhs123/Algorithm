package recursivefunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = func(n);

        System.out.println(result);
    }

    static long func(long n) {
        if (n <= 1) {
            return 1;
        }

        return n * func(n - 1);
    }
}
