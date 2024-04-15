import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char data[] = br.readLine().toCharArray();
        int zeroCnt = 0, oneCnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '1') oneCnt++;
            else zeroCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        for (int start = 0, end = data.length - 1; start < data.length; start++, end--) {
            if (data[start] != ' ' && oneCnt > 0 && data[start] == '1') {
                data[start] = ' ';
                oneCnt--;
            }
            if (data[end] != ' ' && zeroCnt > 0 && data[end] == '0') {
                data[end] = ' ';
                zeroCnt--;
            }
        }
        System.out.println(new String(data).replaceAll(" ",""));

    }

}

