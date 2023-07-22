#include <stdio.h>
#include <stdlib.h>

void sort(int *A, int N);

int main() {
    int *A, N;

    scanf("%d", &N);
    A = (int*)malloc(sizeof(int) * N);
    
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    sort(A, N);

    for (int i = 0; i < N; i++) {
        printf("%d\n", A[i]);
    }

    return 0;
}

void sort(int *A, int N) {
    int max, tmp;

    for (int i = N - 1; i >= 1; i--) {
        max = 0;
        for (int j = 1; j <= i; j++) {
            if (A[j] > A[max]) max = j;
        }

        if (max != i) {
            tmp = A[max];
            A[max] = A[i];
            A[i] = tmp;
        }
    }
} 