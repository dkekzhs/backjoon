#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#define MAX 987654321

int leftPush(char * data,const char * original, int count);
int rightPush(char * data,const char * original, int count);
void leftRotation(char * data);
void rightRotation(char * data);
int solution(const char* A, const char* B) {
    int answer = 0;
    char * leftData = (char *)malloc(strlen(A) +1);
    char * rightData = (char *)malloc(strlen(A) +1);
    char * original = (char *)malloc(strlen(A) +1);
    
    strcpy(leftData, A);
    strcpy(rightData, A);

    
    int left = leftPush(leftData, B, 0);
    int right = rightPush(rightData, B, 0);
    answer = (left < right) ? left : right;
    return (answer == MAX) ? -1 : answer;
}

int rightPush(char * data, const char * original,int count){
    if(strcmp(data, original) == 0) 
        return count;
    
    if(count == 100){
        return MAX;
    }
    
    rightRotation(data);
    return rightPush(data, original, count + 1);
}

void rightRotation(char * data){
    int len = strlen(data);
    char temp = data[len -1];
    for(int i=len -1; i >0; i--){
        data[i] = data[i -1];
    }
    data[0] = temp;
}

int leftPush(char * data, const char * original,int count){
    if(strcmp(data, original) == 0) 
        return count;
    
    if(count == 100){
        return MAX;
    }
    
    leftRotation(data);
    return leftPush(data, original, count + 1);
}

void leftRotation(char * data){
    int len = strlen(data);
    char temp = data[0];
    for(int i=0; i <len -1; i++){
        data[i+1] = data[i];
    }
    data[len -1] = temp;
}


