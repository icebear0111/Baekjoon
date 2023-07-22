#include <stdio.h>
#include <stdlib.h>

void sort(int *A, int N);

int main() {
    int *A, N, k;

    scanf("%d %d", &N, &k);
    A = (int*)malloc(sizeof(int) * N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    sort(A, N);

    printf("%d\n", A[N - k]);

    return 0;
}

void sort(int *A, int N) {
    for (int i = N - 1; i >= 1; i--) {
        int max = 0;
        for (int j = 1; j <= i; j++) {
            if(A[j] > A[max]) max = j;
        }

        if (max != i) {
            int tmp = A[max];
            A[max] = A[i];
            A[i] = tmp;
        }
    }
}