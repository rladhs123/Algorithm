package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q10816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();

            if (map.containsKey(input)) {
                map.replace(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int find = sc.nextInt();

            if (map.containsKey(find)) {
                sb.append(map.get(find)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }
}
