package string;

import java.util.Scanner;

/**
 * 크로아티아 알파벳
 */
public class Q2941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;

        for (int i = 0; i < input.length();) {

            if (i + 2 < input.length() && input.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 3;
            } else if (i + 1 < input.length()) {
                String s = input.substring(i, i + 2);
                if (s.equals("c=") || s.equals("c-") ||
                        s.equals("d-") || s.equals("lj") ||
                        s.equals("nj") || s.equals("s=") ||
                        s.equals("z=")) {
                    count++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            } else {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
