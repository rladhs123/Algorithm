package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 치킨 배달
 *
 * 크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다.
 * 이 도시에 사는 사람들은 치킨을 매우 좋아한다.
 * 따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다. 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
 * 즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
 * 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다.
 * 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
 */
public class Q15686 {

    static int N, M;
    static int[][] map;
    static List<Node> houseList;
    static List<Node> shopList;
    static boolean[] isVisited;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        //1. 치킨집 선택
        //2. 각각의 집에서 치킨 거리 계산
        //3. 도시의 치킨 거리 계산 + 최솟값 비교
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        houseList = new ArrayList<>();
        shopList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    houseList.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    shopList.add(new Node(i, j));
                }
            }
        }

        isVisited = new boolean[shopList.size()];
        backTracking(0, 0);

        System.out.println(result);
    }

    static void backTracking(int depth, int index) {
        if (depth == M) {
            result = Math.min(result, calculateCityDistance());
            return;
        }

        for (int i = index; i < shopList.size(); i++) {
            isVisited[i] = true;
            backTracking(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    static int calculateCityDistance() {
        int distance = 0;
        for (Node house : houseList) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < shopList.size(); i++) {
                if (isVisited[i]) {
                    min = Math.min(min, Math.abs(house.y - shopList.get(i).y) + Math.abs(house.x - shopList.get(i).x));
                }
            }
            distance += min;
        }
        return distance;
    }
}
