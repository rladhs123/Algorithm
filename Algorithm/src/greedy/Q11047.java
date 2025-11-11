package greedy;

import java.util.Scanner;

public class Q11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = array[i];

            if (k == 0) {
                break;
            }

            if (curr <= k) {
                result += k / curr;
                k -= curr * (k / curr);
            }
        }

        System.out.println(result);
    }
}
