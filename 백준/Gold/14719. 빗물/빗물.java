import java.util.*;
import java.io.*;


public class Main {

    static int W, H;
    static int map[][];
    static int count =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);

        map = new int[H][W];
        count = 0;

        s = br.readLine().split(" ");

        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(s[i]);

            for (int j = 0; j < height; j++) {
                map[j][i] = 1;
            }

        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 1) fill(i, j);
            }
        }

        System.out.println(count);
//        printMap(map);

    }



    static void printMap(int map[][]){

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("____________________________");
    }

    static void fill(int height, int weight) {
        int startX = weight +1;
        boolean flag = false;
        while (startX < W) {
            if(map[height][startX] == 1){
                flag = true;
                break;
            }
            if(map[height][startX] == 2) return;
            startX++;
        }

        while(weight +1  != startX && flag){
            map[height][--startX] = 2;
            count++;
        }

    }

}

