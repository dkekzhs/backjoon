import java.util.*;
import java.io.*;


public class Main {

    static int map[][];
    static int N,M;
    static final int MAX = 10000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s [] = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i],MAX);
        }
        for (int i = 0; i < N; i++) {
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]) -1 ;
            int b = Integer.parseInt(s[1]) -1 ;
            map[a][b] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }


        int count =0;
        int mid = (N + 1) / 2;

        for (int i = 0; i < N; i++) {
            int lightCount = 0;
            int heavyCount = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] != MAX && map[i][j] > 0) {
                    lightCount++;
                }
                if (map[j][i] != MAX && map[j][i] > 0) {
                    heavyCount++;
                }
            }
            if (heavyCount >= mid || lightCount >= mid) {
                count++;
            }
        }

  
        System.out.println(count);

    }





}

