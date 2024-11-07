import java.util.*;


class Solution {
    final int MAX = 987654321;
    
    public int solution(String[] strs, String t) {
        int answer = 0;
        int len = t.length();
        int[] dp = new int[len +1];
        
        Arrays.fill(dp,MAX);
        dp[0] =0 ;
        
        for(int i=0; i<=len; i++){
            
            for(String str : strs){
                boolean flag = true;
                
                for(int j=0; j<str.length() && i+j < len;j++){
                    if(t.charAt(i+j) != str.charAt(j)){
                        flag = false;
                        break;
                    }    
                }
                
                if(flag){
                    int p = i + str.length();
                    if(p <=len)  dp[i + str.length()] = Math.min(dp[i] +1, dp[i + str.length()]);

                }
 
            }
            
        }
        answer = MAX == dp[len] ? -1 : dp[len];
        
        return answer;
    }
}