package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 * <p>
 * 원이 아닌 사각형이면 문제가 쉬운데, 원이라 좀 힘듬
 * 원안에 정사각형을 만들고, 그 정사각형안의 정수의 갯수를 세고 원의 각 꼭짓점 갯수 4개를 더하면 그 원에 포함된 갯수가 나옴.
 * 사각형의 시작점인 0,0 부터 각 사각형의 변에 있는좌표, 사각형 안의 좌표를 계산하는 공식은 x^2+2x+1
 * 두개의 사이에 있는 점의 갯수를 포함 (작은원의 꼭지점? 까지) 해야 하기 때문에 두개의 사각형 점 갯수를 구하고 +4를 해주면됨
 *
 * 내방법 트림
 */
public class Q181187 {
    public long solution(int r1, int r2) {
        long answer = 0;

        //r1과 r2의 사각형 한변의 길이 구하기
        int r1width = getRectangleWidth(r1);
        int r2width = getRectangleWidth(r2);

        //각 사각형의 정수 좌표갯수구하기
        int r1IntegerCommaCount = getIntegerCommaCount(r1width);
        int r2IntegerCommaCount = getIntegerCommaCount(r2width);

        //두 좌표가 겹치는 부분만 찾아야 하므로 r2 - r1
        //큰 원의 각 정수좌표 점도 더해야 하므로 + 4
        return r2IntegerCommaCount - r1IntegerCommaCount + 4;
    }

    public long solution2(int r1, int r2) {
        long answer = 0;

        // 4개의 사분면 중 1개만 구한뒤 4를 곱한다.
        for( int i = 1; i <= r2 ; i++){
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            answer += ( (long)y2 - (long)Math.ceil(y1) + 1);
        }
        answer *= 4;

        return answer;
    }

    public int getRectangleWidth(int radius) {
        return (int) Math.floor(Math.sqrt((radius * radius) + (radius * radius)));
    }

    public int getIntegerCommaCount(int width) {
        return (width * width) + (2 * width) + 1;
    }
}
