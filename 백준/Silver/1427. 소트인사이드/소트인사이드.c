#include <stdio.h>
#include <stdlib.h>

void sort(int *A, int N);

int main() {
    int N, *A, i = 0, size;

    scanf("%d", &N);
    int num = N;

    while (num > 0) {
        num /= 10;
        i++;
    }

    size = i;
    A = (int*)malloc(sizeof(int) * size);

    i = 0;
    while (N > 0) {
        A[i] = N % 10;
        N /= 10;
        i++;
    }

    sort(A, size);

    for (int j = 0; j < i; j++) {
        printf("%d", A[j]);
    }
    printf("\n");

    return 0;
}

void sort(int *A, int N) {
    for (int i = N - 1; i >= 1; i--) {
        int min = 0;
        for (int j = 0; j <= i; j++) {
            if (A[min] > A[j]) min = j;
        }

        if (min != i) {
            int tmp = A[min];
            A[min] = A[i];
            A[i] = tmp;
        }
    }
}