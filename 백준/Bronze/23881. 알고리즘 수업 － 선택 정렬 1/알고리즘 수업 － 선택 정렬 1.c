#include <stdio.h>
#include <stdlib.h>

void selection_sort(int* A, int N, int K);

int main() {
    int *A, N, K;

    scanf("%d %d", &N, &K);
    A = (int*)malloc(sizeof(int) * N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    selection_sort(A, N, K);

    return 0;
}

void selection_sort(int *A, int N, int K) {
    int i, j, max, idx, tmp, cnt = 0;
    for (i = N - 1; i >= 1; i--) {
        max = 0;
        for (j = 0; j < i + 1; j++) {
            if (A[j] > max) {
                max = A[j];
                idx = j;
            }
        }

        if (idx != i) {
            tmp = A[i];
            A[i] = A[idx];
            A[idx] = tmp;
            cnt++;
        }

        if (cnt == K) {
            printf("%d %d\n", A[idx], A[i]);
            break;
        }
    }

    if (cnt < K) {
        printf("%d\n", -1);
    }
}