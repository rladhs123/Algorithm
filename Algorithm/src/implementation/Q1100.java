package implementation;

import java.util.Scanner;

public class Q1100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];
        int result = 0;

        for (int i = 0; i < 8; i++) {
            String input = sc.next();
            for (int j = 0; j < 8; j++) {
                board[i][j] = input.charAt(j);

                if (board[i][j] == 'F') {
                    if (i % 2 == 0 && j % 2 == 0) {
                        result++;
                    } else if (i % 2 == 1 && j % 2 == 1) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
