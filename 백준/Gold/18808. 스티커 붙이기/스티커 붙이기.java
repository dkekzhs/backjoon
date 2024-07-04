import java.util.*;
import java.io.*;

//스티커 붙이기
//하라는대로 하면 됨
public class Main {
    static int N,M,K; // N = Y | M = X | K = 종이수
    static int notebook[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        notebook =  new int[N][M];
        for (int i = 0; i < K; i++) {
            s =  br.readLine().split(" ");
            int stickerN = Integer.parseInt(s[0]);
            int stickerM = Integer.parseInt(s[1]);

            int sticker[][] = new int[stickerN][stickerM];

            for (int j = 0; j < stickerN; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < stickerM; k++) {
                    sticker[j][k] = Integer.parseInt(s[k]);
                }
            }

            //go
            go(sticker, stickerN, stickerM);
        }
        count();


    }

    private static void count() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(notebook[i][j] ==1) count++;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        System.out.println(sb);
    }

    private static void go(int[][] sticker, int stickerN, int stickerM) {
        int x = 0, y= 0;
        boolean flag = false;
        boolean flag2 = true;
        while(y < N){
            flag = false;
            for (int i = 0; i < stickerN; i++) {
                for (int j = 0; j < stickerM; j++) {
                    int xx = x + j;
                    int yy = y + i;

                    if (sticker[i][j] == 1) {
                        if (yy >= N || xx >= M || xx < 0 || yy < 0) {
                            flag = true;
                        }
                        else if (notebook[yy][xx] == 1) {
                            flag = true;
                        }
                    }
                }
                if(flag) break;
            }
            if(!flag){
                for (int i = 0; i < stickerN; i++) {
                    for (int j = 0; j < stickerM; j++) {
                        if(sticker[i][j] ==1)notebook[y+i][x+j] = 1;
                    }
                }
                flag2 = false;
                break;
            }
            if(x == M){
                y++;
                x=0;
            }
            else if(x <M) x++;
        }

        for (int degree = 90; degree <=270 && flag2; degree+=90) {

            x= 0; y=0;
            int temp[][] = rotate(sticker, degree);
            while(y<N){
                flag = false;
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp[0].length; j++) {
                        int xx = x + j;
                        int yy = y + i;

                        if (temp[i][j] == 1) {
                            if (yy >= N || xx >= M || xx < 0 || yy < 0) {
                                flag = true;
                            }
                            else if (notebook[yy][xx] == 1) {
                                flag = true;
                            }
                        }
                    }
                    if(flag) break;
                }
                if(!flag){
                    for (int i = 0; i < temp.length; i++) {
                        for (int j = 0; j < temp[0].length; j++) {
                            if(temp[i][j] ==1)notebook[y+i][x+j] = 1;
                        }
                    }
                    flag2= false;
                    break;
                }
                if(x == M){
                    y++;
                    x=0;
                }
                else if(x <M) x++;
            }
            if(!flag) break;
        }




    }

    static int[][] rotate(int[][] arr, int degree) {
        int[][] rotate;
        int n = arr.length;
        int m = arr[0].length;

        switch (degree) {
            case 90:
            case 270:
                rotate = new int[m][n];
                break;
            case 180:
                rotate = new int[n][m];
                break;
            default:
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                switch (degree) {
                    case 90:
                        rotate[i][j] = arr[n-1-j][i];
                        break;
                    case 180:
                        rotate[i][j] = arr[n-1-i][m-1-j];
                        break;
                    case 270:
                        rotate[i][j] = arr[j][m-1-i];
                        break;
                }
            }
        }

        return rotate;
    }

}

