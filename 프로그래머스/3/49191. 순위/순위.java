import java.util.*;

class Solution {
    int answer;
    boolean map[][];
    public int solution(int n, int[][] results) {
        init(n,results);


        return find(n,results);
    }
    public int find(int n, int[][] results){
        
        for(int k=0;k<=n;k++){
            for(int a=0;a<=n;a++){
                for(int b=0;b<=n;b++){
                    if(map[a][k] && map[k][b]){
                        map[a][b] = true;
                    }
                    
                }
            }
        }
        
        
        int count = 0;
        
        for(int i=1; i<=n; i++){
            int rankCount = 0;
            for(int j=1; j<=n;j++){
                if(map[i][j] || map[j][i]){
                    rankCount++;
                } 
                    
            } 
            if(rankCount == n-1) {
                count++;
            }
        }
        
        return count;
    }
    
    
    public void init(int n, int [][] results){
        map = new boolean [n+1][n+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(map[i],false);
        }
        
        for(int i=0;i< results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            
            map[a][b] = true;
            
        }
        
        
        
        answer= 0;
        
    }
    
}