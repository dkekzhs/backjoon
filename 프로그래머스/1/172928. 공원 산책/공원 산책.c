#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 공원 산책 문제를 해결하는 함수
int* solution(const char* park[], size_t park_len, const char* routes[], size_t routes_len) {
    int* answer = (int*)malloc(2 * sizeof(int)); 
    int x = 0, y = 0;  
    
  
    for (int i = 0; i < park_len; i++) {
        for (int j = 0; j < strlen(park[i]); j++) {
            if (park[i][j] == 'S') {
                x = i;  
                y = j; 
                break;
            }
        }
    }
    

    for (int i = 0; i < routes_len; i++) {
        char direction;
        int distance;
        
        sscanf(routes[i], "%c %d", &direction, &distance);
        bool move_check = true;  
        int new_x = x;
        int new_y = y;
        for (int j = 0; j < distance; j++) {

            
   
            if (direction == 'E') {
                new_y++;  
            } else if (direction == 'W') {
                new_y--;  
            } else if (direction == 'N') {
                new_x--; 
            } else if (direction == 'S') {
                new_x++;  
            }
            
            if (new_x < 0 || new_x >= park_len || new_y < 0 || new_y >= strlen(park[0]) || park[new_x][new_y] == 'X') {
                move_check = false;  
                break;
            }

        }
        if(move_check){
            x = new_x;
            y = new_y;
        }
    }
    
    answer[0] = x;
    answer[1] = y;
    
    return answer;
}


