import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static Point answer;
    static int rightMax;
    static final int counterLen = 1000002;
    static long counter[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        input(br);
        play();
        Print(sb);

    }

    private static void Print(StringBuilder sb) {
        if(answer.x == Integer.MAX_VALUE) answer = new Point(0, 0);
        sb.append(answer.x).append(" ").append(answer.y).append("\n");
        System.out.println(sb);
    }

    private static void play() {

        int left = 0, right = 0;
        long sum = 0;
        while (right <= rightMax){

            if(sum < K) sum += counter[++right];
            else if(sum > K) sum -= counter[++left];
            else{
                answer.x = left;
                answer.y = right;
                return;
            }

        }
    }



    private static void input(BufferedReader br) throws Exception {
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        answer = new Point(0,0);
        counter = new long[counterLen];
        rightMax = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            rightMax = Math.max(rightMax, y);

            counter[x+1]++;
            counter[y+1]--;
        }

        for (int i = 1; i <counterLen; i++) {
            counter[i] += counter[i - 1];
        }
    }


}
