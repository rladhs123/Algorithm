package implementation;

import java.util.Scanner;

public class Q1193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        //n(n + 1) / 2 = X

        int n = 1;
        int sum = 1;
        while (sum < X) {
            n++;
            sum = n * (n + 1) / 2;
        }
        
        //짝수 대각선은 오른쪽 위에서 왼쪽 아래로
        //홀수 대각선은 왼쪽 아래에서 오른쪽 위로
        int top, bottom;
        if (n % 2 == 0) {
            top = 1;
            bottom = n;
            for (int i = 1; i < X - (n - 1) * n / 2; i++) {
                top++;
                bottom--;
            }
        } else {
            top = n;
            bottom = 1;
            for (int i = 1; i < X - (n - 1) * n / 2; i++) {
                top--;
                bottom++;
            }
        }

        System.out.println(top + "/" + bottom);
    }
}
