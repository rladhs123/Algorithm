package programmers;

public class Q20250922 {

    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;

            for (int i = 0; i < schedules.length; i++) {
                int schedule = schedules[i];
                int hour = schedule / 100;
                int minutes = schedule % 100 + 10;

                if (minutes >= 60) {
                    hour += 1;
                    minutes -= 60;
                }

                if (hour == 24) {
                    hour = 0;
                }

                schedule = hour * 100 + minutes;
                boolean check = true;

                for (int j = 0; j < 7; j++) {
                    if ((startday + j) % 7 == 0 || (startday + j) % 7 == 6) {
                        continue;
                    }

                    int day = timelogs[i][j];

                    if (schedule < day) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
