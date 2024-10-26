import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] c = s.toCharArray();

        int aCount = 0;

        int n = c.length;
        char[] c2 = (s + s).toCharArray();

        for (char value : c) {
            if (value == 'a') aCount++;
        }
        int bCount = 0;

        for (int i = 0; i < aCount; i++) {
            if(c[i] == 'b') bCount++;
        }
        int answer = bCount;
        for (int i = 1; i <n ; i++) {
            if(c2[i -1] == 'b') bCount--;
            if(c2[i + aCount -1] =='b') bCount++;
            answer = Math.min(answer, bCount);
        }


        System.out.println(answer);
    }


    }


