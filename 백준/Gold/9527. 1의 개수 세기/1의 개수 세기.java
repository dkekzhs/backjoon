import org.w3c.dom.Node;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

//d[i] = 2 * d[i-1] + 2^i
//d [ i ] = d [ i − 1 ] + ( i 번 비트를 뺀 나머지 반복되는 수들의 1의 개수) + (i번째 비트에 나타나는 1의 수)\
//비트가 커져있을 때 개수만큼 더해서 정답을 구함
public class Main {
    static long a,b;
    static long data[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        a = Long.parseLong(s[0]);
        b = Long.parseLong(s[1]);

        data = new long[55];
        data[0] = 1;

        for (int i = 1; i < 55; i++) {
            data[i] = 2 * data[i - 1] + (1L << i);
        }
        System.out.println(start(b) - start(a-1));
    }

    static long start(long number) {
        long answer = number & 1;

        for (int i = 55; i >0 ; i--) {
            if ((number & (1L << i)) != 0) {

                answer += data[i - 1] + (number - (1L << i) + 1);
                number -= 1L << i;
            }
        }

        return answer;
    }



}
