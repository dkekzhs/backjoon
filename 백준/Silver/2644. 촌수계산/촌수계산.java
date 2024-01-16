import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int c1,c2;
    static int m;
    static ArrayList<Integer> graph[];
    static int answer;
    static boolean visited[];
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        c1 = Integer.parseInt(s[0]);
        c2 = Integer.parseInt(s[1]);
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <=n ; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        answer = 0;
        dfs(c1, c2,0);

        System.out.println(answer == 0 ? -1 : answer );
    }

    private static void dfs(int a, int b, int cnt) {
        if(a == b) answer = Math.max(cnt,answer);
        visited[a] = true;

        for (int from :graph[a]) {
            if(visited[from]) continue;
            dfs(from, b, cnt + 1);
        }


    }
}