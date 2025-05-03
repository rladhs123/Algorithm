package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 회의실 배정
 *
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 */
public class Q1931 {

    static int N;

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Meeting[] array = new Meeting[N];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            array[i] = new Meeting(start, end);
        }

        Arrays.sort(array);

        int count = 1;
        Meeting m = array[0];
        for (int i = 1; i < N; i++) {
            if (m.end <= array[i].start) {
                m = array[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
