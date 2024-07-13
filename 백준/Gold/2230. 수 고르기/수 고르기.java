import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    //M 차이나는 수, N 입력 개수
    static int N, M;

    static int map[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;
        Arrays.sort(map);
        long answer = Long.MAX_VALUE;

        while (right < N) {
            int diff = map[right] - map[left];
            if(diff >= M){
                answer = Math.min(answer, diff);
                left++;
            }
            else right++;
            if (left == right) {
                right++;
            }

        }

        System.out.println(answer);

    }




}
