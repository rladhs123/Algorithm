package implementation;

import java.util.Scanner;

public class Q11098 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int max = -1;
            String best = "";

            for (int j = 0; j < n; j++) {
                int price = sc.nextInt();
                String name = sc.next();

                if (price > max) {
                    best = name;
                    max = price;
                }
            }

            sb.append(best).append('\n');
        }

        System.out.println(sb);
    }
}
