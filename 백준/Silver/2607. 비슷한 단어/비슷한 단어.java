import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) -1 ;
        int answer = 0;

        String s = br.readLine();
        int length = s.length();
        char[] firstWord = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < firstWord.length; i++) {
            if (!map.containsKey(firstWord[i])) {
                map.put(firstWord[i], 1);
            }else{
                map.put(firstWord[i], map.get(firstWord[i])+ 1);
            }
        }


        while(N -->0){
            s = br.readLine();
            if (Math.abs(s.length() - length) > 1) continue;
            char [] secondWords = s.toCharArray();
            HashMap<Character, Integer> temp = new HashMap<>(map);
            for (int i = 0; i < secondWords.length; i++) {
                if (!temp.containsKey(secondWords[i])) {
                    temp.put(secondWords[i], -1);
                } else {
                    temp.put(secondWords[i], temp.get(secondWords[i])- 1);
                }
            }

            int cnt = 0;
            for (int value : temp.values()) {
                cnt += Math.abs(value); 
            }
            if (cnt <= 2) { 
                answer++;
            }
        }

        System.out.println(answer);
    }
}
// AB , B , ABC
// DOG DOOG