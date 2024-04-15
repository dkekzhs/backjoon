import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {

    static int N,K;
    static Queue<Integer>[] friendPending;
    static final int MAX_LENGTH = 21;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        friendPending = new Queue[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            friendPending[i] = new LinkedList<>();
        }
        long answer =0;

        for (int rank = 1; rank <= N; rank++) {
            int inputLength = br.readLine().trim().length();

            while(!friendPending[inputLength].isEmpty() &&
                    rank -friendPending[inputLength].peek() >K) {
                friendPending[inputLength].poll();
            }
            answer += friendPending[inputLength].size();
            friendPending[inputLength].offer(rank);
        }
        System.out.println(answer);
    }
}
