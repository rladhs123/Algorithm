package backtracking;

import java.util.Scanner;

/**
 * 연산자 끼워넣기
 *
 * N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다.
 * 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
 * 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
 * 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다.
 * 이때, 주어진 수의 순서를 바꾸면 안 된다.
 * N개의 수와 N-1개의 연산자가 주어졌을 때,
 * 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 */
public class Q14888 {

    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] array, operator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N];
        operator = new int[4];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < operator.length; i++) {
            operator[i] = sc.nextInt();
        }

        backTracking(array[0], 0);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void backTracking(int num, int depth) {
        if (depth == N - 1) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0: backTracking(num + array[depth + 1], depth + 1); break;
                    case 1: backTracking(num - array[depth + 1], depth + 1); break;
                    case 2: backTracking(num * array[depth + 1], depth + 1); break;
                    case 3: backTracking(num / array[depth + 1], depth + 1); break;
                }

                operator[i]++;
            }
        }
    }
}
