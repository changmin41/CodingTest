class Solution {
    public int solution(long num) {
        int result = 0; // 작업 횟수를 저장할 변수
        
        while (true) {
            // num이 1이 되거나 작업 횟수가 500 이상이 되면 루프 종료
            if (num == 1 || result >= 500) break;
            
            result++; // 작업 횟수 증가
            
            // num이 짝수이면 2로 나누고, 홀수이면 3을 곱하고 1을 더함
            if (num % 2 == 0) num = num / 2;
            else num = num * 3 + 1;
        }
        
        // num이 1이 된 경우 작업 횟수를 반환, 그렇지 않으면 -1 반환
        return (num == 1) ? result : -1;
    }
}