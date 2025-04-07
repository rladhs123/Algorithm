package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 알파벳
 *
 * 세로R칸, 가로C칸으로 된 표 모양의 보드가 있다.
 * 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1열 1행)에 말이 있다.
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,
 * 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
 * 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 */
public class Q1987 {

    static int R, C;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    //지나간 곳의 알파벳을 리스트에 저장해서 contain 함수로 방문 체크 + 최대 칸 수 계산(size 함수)
    static List<Character> characterList;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        characterList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int y, int x) {
        if (characterList.contains(map[y][x])) {
            max = Math.max(max, characterList.size());
            return;
        }
        characterList.add(map[y][x]);
        max = Math.max(max, characterList.size());

        for (int i = 0; i < dy.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                dfs(nextY, nextX);
            }
        }
        characterList.remove(characterList.size() - 1);
    }
}
