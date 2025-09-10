package graph.bfs;

import java.util.*;

/**
 * 경쟁적 전염
 *
 * NxN 크기의 시험관이 있다. 시험관은 1x1 크기의 칸으로 나누어지며, 특정한 위치에는 바이러스가 존재할 수 있다.
 * 모든 바이러스는 1번부터 K번까지의 바이러스 종류 중 하나에 속한다.
 * 시험관에 존재하는 모든 바이러스는 1초마다 상, 하, 좌, 우의 방향으로 증식해 나간다.
 * 단, 매 초마다 번호가 낮은 종류의 바이러스부터 먼저 증식한다.
 * 또한 증식 과정에서 특정한 칸에 이미 어떠한 바이러스가 존재한다면, 그 곳에는 다른 바이러스가 들어갈 수 없다.
 *
 * 시험관의 크기와 바이러스의 위치 정보가 주어졌을 때,
 * S초가 지난 후에 (X,Y)에 존재하는 바이러스의 종류를 출력하는 프로그램을 작성하시오.
 * 만약 S초가 지난 후에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력한다. 이 때 X와 Y는 각각 행과 열의 위치를 의미하며,
 * 시험관의 가장 왼쪽 위에 해당하는 곳은 (1,1)에 해당한다.
 */
public class Q18405 {

    static int N, K;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Virus> virusList = new ArrayList<>();
    static int S, targetY, targetX;

    static class Node {
        int virus, y, x;

        public Node(int virus, int y, int x) {
            this.virus = virus;
            this.y = y;
            this.x = x;
        }
    }

    static class Virus implements Comparable<Virus>{
        int num, y, x;

        public Virus(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Virus o) {
            return num - o.num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];

        //맵 입력받고 바이러스가 입력으로 들어오면 리스트에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] != 0) {
                    virusList.add(new Virus(map[i][j], i, j));
                }
            }
        }

        S = sc.nextInt();
        targetY = sc.nextInt();
        targetX = sc.nextInt();

        Collections.sort(virusList);

        bfs();

        System.out.println(map[targetY - 1][targetX - 1]);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int t = 0;

        for (Virus virus : virusList) {
            queue.offer(new Node(virus.num, virus.y, virus.x));
        }

        while (!queue.isEmpty()) {
            if (t == S) {
                break;
            }
            int virusSize = queue.size();

            for (int i = 0; i < virusSize; i++) {
                Node curr = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nY = curr.y + dy[j];
                    int nX = curr.x + dx[j];

                    if (nY >= 0 && nX >= 0 && nY < N && nX < N) {
                        if (map[nY][nX] == 0) {
                            map[nY][nX] = curr.virus;
                            queue.offer(new Node(curr.virus, nY, nX));
                        }
                    }
                }
            }

            t++;
        }
    }
}
