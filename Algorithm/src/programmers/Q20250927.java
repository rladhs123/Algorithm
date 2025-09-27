package programmers;

import java.util.Arrays;

public class Q20250927 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int leftIndex = 0;
        int rightIndex = people.length - 1;

        //가장 무거운 사람과 가장 가벼운 사람을 매칭해서 태움
        //무게가 넘는 경우 가장 무거운 사람 보트를 따로 주고 인덱스를 줄인 후 다음으로 무거운 사람 찾음
        while (leftIndex <= rightIndex) {
            if (people[leftIndex] + people[rightIndex] <= limit) {
                leftIndex++;
            }

            rightIndex--;
            answer++;
        }

        return answer;
    }
}
