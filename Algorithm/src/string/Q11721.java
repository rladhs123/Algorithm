package string;

import java.util.Scanner;

public class Q11721 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length() / 10;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(s.substring(i * 10, (i + 1) * 10)).append('\n');
        }

        sb.append(s.substring(n * 10, s.length()));

        System.out.print(sb);
    }
}
