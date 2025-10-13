package implementation;

import java.util.Scanner;

public class Q7567 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        boolean isReverse;
        int sum = 10;

        if (input.charAt(0) == '(') {
            isReverse = false;
        } else {
            isReverse = true;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                if (isReverse) {
                    sum += 10;
                } else {
                    sum += 5;
                }
                isReverse = false;
            } else {
                if (isReverse) {
                    sum += 5;
                } else {
                    sum += 10;
                }
                isReverse = true;
            }
        }

        System.out.println(sum);
    }
}
