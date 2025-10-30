package bruteforce;

import java.util.Scanner;

public class Q2303 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int[] array = new int[5];

            for (int j = 0; j < 5; j++) {
                array[j] = sc.nextInt();
            }

            int max = -1;

            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int curr = (array[j] + array[k] + array[l]) % 10;
                        if (curr > max) {
                            max = curr;
                        }
                    }
                }
            }

            result[i] = max;
        }

        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (result[i] >= max) {
                max = result[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex + 1);
    }
}
