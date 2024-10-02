import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int dp[];
    static int test_case;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = 20000;
        dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n; i++) {
            dp[i] = dp[i-3] + (i/2) + 1;
        }

        test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            int answer = Integer.parseInt(br.readLine());
            sb.append(dp[answer]).append("\n");
        }

        System.out.println(sb);

    }


    }


