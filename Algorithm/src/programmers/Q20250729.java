package programmers;

public class Q20250729 {

    static int answer;

    static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, 0, 0, target);
        return answer;
    }

    static void dfs(int[] numbers, int depth, int sum, int target) {
        if (sum == target && depth == numbers.length) {
            answer++;
            return;
        }

        if (depth == numbers.length) {
            return;
        }

        dfs(numbers, depth + 1, sum + numbers[depth], target);
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int result = solution(numbers, 4);

        System.out.println(result);
    }
}
