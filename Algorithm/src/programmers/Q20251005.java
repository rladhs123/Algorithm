package programmers;

public class Q20251005 {

    //N, S, W, E
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] map = new char[park.length][park[0].length()];
        int y = 0;
        int x = 0;

        for (int i = 0; i < map.length; i++) {
            String s = park[i];
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        int moveIndex = -1;

        for (int i = 0; i < routes.length; i++) {
            int currY = y;
            int currX = x;
            char direction = routes[i].charAt(0);
            boolean check = false;

            if (direction == 'N') {
                moveIndex = 0;
            } else if (direction == 'S') {
                moveIndex = 1;
            } else if (direction == 'W') {
                moveIndex = 2;
            } else {
                moveIndex = 3;
            }

            int move = routes[i].charAt(2) - '0';
            int nextY = -1;
            int nextX = -1;

            for (int j = 0; j < move; j++) {
                nextY = currY + dy[moveIndex];
                nextX = currX + dx[moveIndex];

                if (nextY >= 0 && nextX >= 0 && nextY < map.length && nextX < map[0].length) {
                    if (map[nextY][nextX] != 'X') {
                        currY = nextY;
                        currX = nextX;
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                y = currY;
                x = currX;
            }
        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }
}
