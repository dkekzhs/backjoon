import java.util.*;
import java.io.*;

//2 * N 타일링 2

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int table[] = new int[1001];
        table[1] = 1;
        table[2] = 3;

        for (int i = 3; i <=N ; i++) {
            table[i] = (table[i-1]%10007 + 2*table[i-2]%10007)%10007;
        }

        System.out.println(table[N]);
    }
}

