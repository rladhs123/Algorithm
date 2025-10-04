package programmers;

public class Q20251004 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] check = new boolean[45];

        for (int i = 0; i < win_nums.length; i++) {
            check[win_nums[i] - 1] = true;
        }

        int zero = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0 && check[lottos[i] - 1]) {
                answer[1]++;
            }

            if (lottos[i] == 0) {
                zero++;
            }
        }

        answer[0] = answer[1] + zero;

        for (int i = 0; i < 2; i++) {
            switch (answer[i]) {
                case 6: answer[i] = 1;
                    break;
                case 5: answer[i] = 2;
                    break;
                case 4: answer[i] = 3;
                    break;
                case 3: answer[i] = 4;
                    break;
                case 2: answer[i] = 5;
                    break;
                default: answer[i] = 6;
                    break;
            }
        }
        return answer;
    }
}
