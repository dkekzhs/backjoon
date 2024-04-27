
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int dx[] ={-1,0,1} , dy[] = {1, 1, 1};
    static int map[][];
    static int N, M ;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        answer = 987654321;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean visited [][] = new boolean[N][M];
            visited[0][i] = true;
            dfs(new Point(i, 0), visited, 10, map[0][i]);
        }
        System.out.println(answer);

    }

    private static void dfs(Point p, boolean[][] visited, int before, int sum) {
        if(p.y == N-1){
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(before == i) continue;
            int x = dx[i] + p.x;
            int y = dy[i] + p.y;

            if (x >= 0 && x < M && y >= 0 && y < N) {
                if(visited[y][x]) continue;
                visited[y][x] = true;
                dfs(new Point(x, y), visited, i, sum + map[y][x]);
                visited[y][x] = false;
            }
        }






    }
}
