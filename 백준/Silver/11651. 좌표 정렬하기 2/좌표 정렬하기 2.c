#include <stdio.h>
#include <stdlib.h>

typedef struct point {
    int x, y;
} point;

int compare(const void *a, const void *b);

int main() {
    int N;
    point *A;

    scanf("%d", &N);
    A = (point*)malloc(sizeof(point) * N);

    for (int i = 0; i < N; i++) {
        scanf("%d %d", &A[i].x, &A[i].y);
    }
    
    qsort(A, N, sizeof(point), compare);

    for (int i = 0; i < N; i++) {
        printf("%d %d\n", A[i].x, A[i].y);
    }
    
    free(A);
    
    return 0;
}

int compare(const void *a, const void *b) {
    point A = *(point *)a;
    point B = *(point *)b;

    if (A.y > B.y) {
        return 1;
    }
    else if (A.y == B.y) {
        if (A.x > B.x) {
            return 1;
        }
        else {
            return -1;
        }
    }
    return -1;
}