package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K){
        return atMost(A, K) - atMost(A, K-1);
    }
    private int atMost(int[] A, int K){
        int res = 0;
        if(A == null || A.length == 0)return res;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < A.length; j++){
            if(map.getOrDefault(A[j], 0) == 0) K--;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while(K < 0){
                map.put(A[i], map.get(A[i]) - 1);
                if(map.get(A[i]) == 0) K++;
                i++;
            }
            res += j-i+1;
        }
        return res;
    }
}
