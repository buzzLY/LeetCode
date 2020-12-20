package com.leetcode;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nb = B[0].length;
        int[][] C = new int[m][nb];
        for(int i = 0; i < m; ++i){
            for(int k = 0 ; k < n; ++k){
                if(A[i][k] != 0){
                    for(int j = 0; j < nb; j++){
                        if(B[k][j] != 0){
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return C;
    }
}
