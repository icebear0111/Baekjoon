#include <stdio.h>
#include <stdlib.h>

void average(int *A);
void median(int *A);

int main() {
    int A[5];

    for (int i = 0; i < 5; i++) {
        scanf("%d", &A[i]);
    }

    average(A);
    median(A);

    return 0;
}

void average(int *A) {
    int sum;

    for (int i = 0; i < 5; i++) {
        sum += A[i];
    }

    printf("%d\n", sum / 5);
}

void median(int *A) {
    for (int i = 4; i >= 1; i--) {
        int max = 0;
        for (int j = 0; j <= i; j++) {
            if (A[j] > A[max]) max = j;
        }

        if (max != i) {
            int tmp = A[max];
            A[max] = A[i];
            A[i] = tmp;
        }
    }

    printf("%d\n", A[2]);
}