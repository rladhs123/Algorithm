package implementation;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int x = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
            String sum = Integer.toString(n + x);
            boolean isPalindrome = true;
            int s = 0;
            int l = sum.length() - 1;

            while (s < l) {
                if (sum.charAt(s) != sum.charAt(l)) {
                    isPalindrome = false;
                    break;
                }

                s++;
                l--;
            }

            if (isPalindrome) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
