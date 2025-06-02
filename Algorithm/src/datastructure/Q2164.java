package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q2164 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (deque.size() != 1) {
            deque.removeFirst();

            deque.add(deque.removeFirst());
        }

        System.out.println(deque.getFirst());
    }
}
