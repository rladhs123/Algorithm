package backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q11478 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
