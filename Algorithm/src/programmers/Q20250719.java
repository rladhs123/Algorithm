package programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Q20250719 {

    static String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");
        int[] array = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(array);

        answer = array[0] + " " + array[array.length - 1];
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = solution(sc.nextLine());

        System.out.println(result);
    }
}
