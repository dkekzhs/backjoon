#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void swap(int *a ,int *b);


long long solution(int a, int b) {
    long long answer = 0;
    if(a > b) swap(&a,&b);
    
    for(int i =a ; i<=b ;i++){
        answer+= i;
    }
    
    return answer;
}

void swap(int *a , int *b){
    int temp = 0;
    temp  = *a;
    *a = *b;
    *b = temp;
    
    
    
    
}

