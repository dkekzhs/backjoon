class Solution {
    int maxStones,answer,left,right; 
    
    
    public int solution(int[] stones, int k) {
        init(stones);
        
        return find(stones,k);
    }
    
    public int find(int [] stones, int k){
        
        while(left <= right){
            int half = (left + right) /2;
            int count = 0;
            maxStones = 0;
            for(int stone : stones){
                if(stone - half <= 0) {    
                    count++;
                    maxStones = Math.max(maxStones,count);
                }
                else count = 0;
            }
            
            if(maxStones >= k) right = half-1;
            else {
                left = half + 1;
                answer = half + 1;
            }
        }
        return answer;
        
    }
    
    public void init(int [] stones){
        maxStones = 0;
        answer =0;
        left = 0;
        right = 0;
        for(int i=0; i< stones.length; i++) right = Math.max(right, stones[i]);
        
    }
}