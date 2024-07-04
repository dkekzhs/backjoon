import java.util.*;
import java.io.*;

//파보나치 수열
// 1. n -1 + n -2 = n 
// 0 = 0 , 1= 1 , n ==2 일떄부터 업데이트 시작
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int table[] = new int[N+1];
        table[1] = 1;

        for (int i = 2; i <= N ; i++) {
            table[i] = table[i-1] + table[i-2];
        }

        System.out.println(table[N]);
    }
}

