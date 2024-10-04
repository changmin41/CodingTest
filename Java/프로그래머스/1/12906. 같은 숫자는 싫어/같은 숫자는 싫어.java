import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();

        for (int num : arr) {
            if (answer.isEmpty() || num != answer.peek()) {
                answer.push(num);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}