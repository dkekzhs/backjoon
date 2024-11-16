// 평균구하기

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void init(int **number, int *N);
double calcul(int *number, int N);
int maxIdx(int *number, int N);
int main(void)
{
    int *number;
    int N;
    init(&number, &N);

    double temp = calcul(number, N);
    printf("%f \n", temp);
    free(number);
    return 0;
}

double calcul(int *number, int N)
{
    double hap = 0;
    int max = maxIdx(number, N);

    for (int i = 0; i < N; i++)
    {
        hap += (double)number[i] / number[max] * 100;
    }

    return hap / N;
}

void init(int **number, int *N)
{
    scanf("%d", N);
    *number = (int *)malloc(sizeof(int) * (*N));
    for (int i = 0; i < *N; i++)
    {
        scanf("%d", &(*number)[i]);
    }
};

int maxIdx(int *number, int N)
{
    int max = 0;
    int idx = 0;
    for (int i = 0; i < N; i++)
    {
        if (max < number[i])
        {
            max = number[i];
            idx = i;
        }
    }
    return idx;
}