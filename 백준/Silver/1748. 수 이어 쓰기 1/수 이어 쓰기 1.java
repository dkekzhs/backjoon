import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int data = Integer.parseInt(s);
        int count = 0;

        int length = s.length();
        
        for (int i = 1; i < length; i++) {
            count += (int) (9 * Math.pow(10, i - 1)) * i;
        }
        count += (int )(data - Math.pow(10, length - 1) + 1) * length;

        System.out.println(count);
    }
}
