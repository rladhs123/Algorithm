package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q23037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(s.charAt(i) - '0', 5);
        }

        System.out.println(sum);
    }
}
