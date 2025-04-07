package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 스타트링크
 *
 * 강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다.
 * 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.
 * 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다.
 * 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
 * 보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다.
 * U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다.
 * (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
 * 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
 * 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
 */
public class Q5014 {

    static int F, S, G, U, D;
    static int[] map;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        map = new int[F + 1];
        isVisited = new boolean[F + 1];

        if (S == G) {
            System.out.println(0);
            return;
        }

        bfs();
        if (map[G] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(map[G]);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        isVisited[S] = true;

        while(!queue.isEmpty()) {
            Integer currPosition = queue.poll();

            int upPosition = currPosition + U;
            int downPosition = currPosition - D;

            if (upPosition < F + 1 && !isVisited[upPosition]) {
                if (upPosition == G) {
                    map[upPosition] = map[currPosition] + 1;
                    return;
                }
                queue.offer(upPosition);
                isVisited[upPosition] = true;
                map[upPosition] = map[currPosition] + 1;
            }
            if (downPosition > 0 && !isVisited[downPosition]) {
                if (downPosition == G) {
                    map[downPosition] = map[currPosition] + 1;
                }
                queue.offer(downPosition);
                isVisited[downPosition] = true;
                map[downPosition] = map[currPosition] + 1;
            }
        }
    }
}
