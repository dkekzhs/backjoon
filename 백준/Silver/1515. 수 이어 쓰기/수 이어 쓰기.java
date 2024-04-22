
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int check =0;
        for (int i = 1; i <=30000 ; i++) {
            String number = String.valueOf(i);

            for (int j = 0; j < number.length(); j++) {
                if(number.charAt(j) == s.charAt(check)) {
                    check++;
                }
                if(check == s.length()){
                    System.out.println(i);
                    return;
                }
            }

        }
        System.out.println(check);

    }

}

