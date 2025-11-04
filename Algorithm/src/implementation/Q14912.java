package implementation;

import java.util.Scanner;

public class Q14912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        String target = String.valueOf(d);
        int count = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == target.charAt(0)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
