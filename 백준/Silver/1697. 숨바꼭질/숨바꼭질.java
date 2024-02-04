import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int a, b, answer;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        answer = Integer.MAX_VALUE;
        visited = new boolean[100001];
        boolean flag = false;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{a,0});
        while (!dq.isEmpty()){
            int[] poll = dq.poll();
            int p = poll[0];
            int t = poll[1];
            if(p == b){
                answer = t;
                flag = true;
                break;
            }

            int [] temp = {p-1,p+1,p*2};
            for (int tt :temp) {
                if(tt >= 0 && tt<=100000){
                    if(visited[tt]) continue;
                    visited[tt] = true;
                    dq.add(new int[]{tt,t+1});
                }

            }
        }
        if(flag)System.out.println(answer);
        else System.out.println(-1);
    }


}