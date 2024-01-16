import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int map[][];
    static int dx[] = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int dy[] = {0, 1, 0, -1};
    static int back_dx[] = {1, 0, -1, 0};
    static int back_dy[] = {0, -1, 0, 1};

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        answer = 0;

        s = br.readLine().split(" ");


        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);


        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        simul(r , c , d);
        System.out.println(answer);
    }

    private static void simul(int x, int y, int d) {
        while (true) {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                answer++;
            }

            boolean canClean = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    canClean = true;
                    break;
                }
            }

            if (!canClean) {
                int back = (d + 2) % 4;
                x += dx[back];
                y += dy[back];
                if (map[x][y] == 1) break;
            }
        }
    }


}