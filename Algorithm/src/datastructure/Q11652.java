package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q11652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long input = sc.nextLong();

            if (map.containsKey(input)) {
                map.replace(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        int max = -1;
        long maxIndex = 0;

        for (Long i : map.keySet()) {
            int count = map.get(i);

            if (count > max) {
                max = map.get(i);
                maxIndex = i;
            } else if (count == max) {
                maxIndex = Math.min(i, maxIndex);
            }
        }

        System.out.println(maxIndex);
    }
}
