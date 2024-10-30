import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int N;
    static final String [] ONE_TWO_THREE = {"1","2","3"};
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        answer = "";
        int len = 0;
        find(len, new StringBuilder());


    }

    static void find(int len, StringBuilder sb) {
        if(len == N){
            String string = sb.toString();
            if (answer.equals("") || answer.compareTo(string) > 0) {
                answer = string;
            }
            System.out.println(answer);
            System.exit(0);
            return;
        }

        for (String ott : ONE_TWO_THREE) {
            sb.append(ott);
            if(isGood(sb))find(len + 1, sb);
            sb.deleteCharAt(len);
        }

    }

    private static boolean isGood(StringBuilder sb) {
        int length = sb.length();
        for (int i = 1; i <= length / 2 ; i++) {
            String a1 = sb.substring(length - i * 2, length - i);
            String a2 = sb.substring(length - i);
            if(a1.equals(a2)) return false;
        }
        return true;
    }

}

