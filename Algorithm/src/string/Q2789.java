package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        String s = "CAMBRIDGE";

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        String input = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!set.contains(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
