import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int [] input,input2;
    static int [] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        answer = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            input[i] = s.charAt(i) - '0';
        }
        s = br.readLine();
        for (int i = 0; i < N; i++) {
            answer[i] = s.charAt(i) - '0';
        }


        input2 = input.clone();
        input2[0] = input2[0] ^ 1;
        if (N > 1) {
            input2[1] = input2[1] ^ 1;
        }

        int cnt = 0,cnt2=1;

        for (int i = 1; i < N; i++) {
            if(input[i-1] != answer[i-1]){
                change(i,0);
                cnt++;
            }
            if(input2[i-1] != answer[i-1]){
                change(i,1);
                cnt2++;
            }
        }
        if (input[N - 1] == answer[N - 1] && input2[N - 1] == answer[N - 1]) {
            System.out.println(Math.min(cnt, cnt2));
        } else if (input[N - 1] == answer[N - 1]) {
            System.out.println(cnt);
        } else if (input2[N - 1] == answer[N - 1]) {
            System.out.println(cnt2);
        } else {
            System.out.println(-1);
        }
    }
    static void change(int idx, int type){
        if(type ==0){
            for (int i = idx-1; i <= idx +1 && i <N ; i++) {
                input[i] = input[i] ^1;
            }

        }else{
            for (int i = idx-1; i <= idx +1 && i <N ; i++) {
                input2[i] = input2[i] ^1;
            }
        }
    }
}
