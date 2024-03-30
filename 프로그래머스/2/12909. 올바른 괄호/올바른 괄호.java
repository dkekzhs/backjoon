import java.util.*;
class Solution {
    
    boolean solution(String s) {
        boolean answer = true;
        Stack st = new Stack<String>();
        
        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);
            if(chr == '(') st.push("(");
            else if (chr == ')' && st.isEmpty()) {
                answer = false;
                break;
            }
            else if (chr == ')' && !st.isEmpty()) {
                st.pop();
            }
        }
        if(!st.isEmpty()){
            answer =false;
        }

        return answer;
    }
}