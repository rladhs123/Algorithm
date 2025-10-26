package implementation;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2592 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int input = sc.nextInt();

            if (!map.containsKey(input)) {
                map.put(input, 1);
            } else {
                map.put(input, map.get(input) + 1);
            }

            sum += input;
        }

        int max = 0;
        int result = 0;

        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                result = i;
            }
        }

        System.out.println(sum / 10 + "\n" + result);
    }
}
