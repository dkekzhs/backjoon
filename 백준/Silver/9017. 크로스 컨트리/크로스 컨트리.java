import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static final int max_length = 201;
    static int N,T;
    static int count[];
    static int score[];
    static int map [];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T -->0){
            N = Integer.parseInt(br.readLine());
            count = new int[max_length];
            score = new int[N];
            map = new int[N];
            String s [] = br.readLine().split(" ");
            for(int i =0; i< N; i++){
                map[i] = Integer.parseInt(s[i]);
                count[map[i]]++;
            }
            counting();
            sb.append(answer()).append("\n");
        }
        System.out.println(sb);

    }

    private static int answer() {
        Point[] teamCnt = new Point[max_length];
        int visited[] = new int[max_length];
        for (int i = 0; i < teamCnt.length; i++) {
            teamCnt[i] = new Point(0, 0);
        }
        Arrays.fill(visited,Integer.MAX_VALUE);
        for(int i=0; i< N; i++){
            if(count[map[i]] < 6) continue;
            int hap = teamCnt[map[i]].x + score[i];
            int peopleCnt = teamCnt[map[i]].y + 1;
            if(peopleCnt ==5){
                if(visited[map[i]] == Integer.MAX_VALUE ){
                    visited[map[i]] = score[i];
                }
                continue;
            }
            teamCnt[map[i]] = new Point(hap, peopleCnt);


        }
//        System.out.println(Arrays.toString(visited));
//        System.out.println(Arrays.toString(teamCnt));
        return findAnswer(teamCnt,visited);
    }

    private static int findAnswer(Point [] teamCnt,int []visited) {
        int rowIdx = Integer.MAX_VALUE;
        int rowScore = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(teamCnt[map[i]].y == 4){
                if (rowIdx == Integer.MAX_VALUE) {
                    rowIdx = visited[map[i]];
                    rowScore = teamCnt[map[i]].x;
                    answer = map[i];
                    continue;
                }
                if (teamCnt[map[i]].x < rowScore) {
                        rowIdx = visited[map[i]];
                        rowScore = teamCnt[map[i]].x;
                        answer = map[i];
                }
                else if (teamCnt[map[i]].x == rowScore){
                    if (visited[map[i]] < rowIdx) {
                        rowIdx = visited[map[i]];
                        rowScore = teamCnt[map[i]].x;
                        answer = map[i];
                    }
                }
            }
        }

        return answer;

    }

    private static void counting() {
        int cnt = 0;
        for(int i=0;i< N; i++){
            if(count[map[i]] <6) continue;
            score[i] = ++cnt;
        }
//        System.out.println(Arrays.toString(score));
    }

}
