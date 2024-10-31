import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N,M;
    static int trees[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s [] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        trees = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(trees);
        long start = 1;
        long end = 2000000000;
        long answer = 0;
        while (start < end) {
            long half = (start + end) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                if(half >= trees[i]) continue;
                count += (trees[i] - half);
            }
            if(count >= M){
                start = half+1;
                answer = Math.max(half, answer);
            }
            else{
                end = half;
            }


        }
        System.out.println(answer);
    }



}

