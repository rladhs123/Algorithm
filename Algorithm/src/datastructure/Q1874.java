package datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 수열
 * <p>
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
 * 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 */
public class Q1874 {

    static int N;
    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        int num = 1;
        for (int i = 0; i < N; i++) {
            int currNum = array[i];

            while (num <= currNum) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }

            if (stack.peek() == currNum) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
