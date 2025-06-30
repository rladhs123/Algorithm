package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q18870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        int[] sortedArray = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            sortedArray[i] = array[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sortedArray);
        int sequence = 0;

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortedArray[i])) {
                map.put(sortedArray[i], sequence);
                sequence++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(array[i])).append(' ');
        }

        System.out.println(sb);
    }
}
