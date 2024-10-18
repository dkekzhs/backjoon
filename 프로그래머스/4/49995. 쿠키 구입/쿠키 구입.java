class Solution {
    int answer = -1;
    int r;
    public int solution(int[] cookie) {
        init(cookie);    
        play(cookie);
        return answer == -1 ? 0 : answer;
    }
    
    public void play(int [] cookie){

        for(int mid = 0; mid < r; mid++){
            int left = mid;
            int right = mid+1;
            
            int leftSum = cookie[left];
            int rightSum = cookie[right];
            
            while(left >=0 && right <= r){
                if(leftSum == rightSum){
                    answer = Math.max(leftSum,answer);
                }
                
                if(leftSum  <= rightSum && left >0){
                    leftSum += cookie[--left];
                }
                else if (leftSum > rightSum && right < r){
                    rightSum += cookie[++right];
                }
                else break;
                
                
            }
            
        }
        
    }
    
    public void init(int [] cookie){
        r = cookie.length -1;
        
        
        
    }
}