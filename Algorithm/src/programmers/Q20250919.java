package programmers;

public class Q20250919 {

    public String solution(int a, int b) {
        String answer = "";
        //2016년 1월 1일 ~ 2016년 12월 31일 = 366일 (윤년 + 1)
        //            1  2  3
        //4  5  6  7  8  9  10
        //11 12 13 14 15 16 17

        for (int i = 1; i < a; i++) {
            if (i == 2) {
                b += 29;
            } else if(i % 2 == 0) {
                if (i == 8 || i == 10 || i == 12) {
                    b += 31;
                } else {
                    b += 30;
                }
            } else {
                if (i == 9 || i == 11) {
                    b += 30;
                } else {
                    b += 31;
                }
            }
        }

        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        answer = day[b % 7];

        return answer;
    }
}
