package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
    public static void main(String[] args){
        int [] one = {1,0,0,2,3};
        int [] two = {0,3,0,4,0};
        SparseVector sparseVectorOne = new SparseVector(one);
        SparseVector sparseVectorTwo = new SparseVector(two);
        System.out.println(sparseVectorTwo.dotProduct(sparseVectorOne));
        System.out.println(sparseVectorOne.dotProduct(sparseVectorTwo));
    }
}

class SparseVector {

    Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] != 0){
                map.put(i , nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int output = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(vec.map.containsKey(entry.getKey())){
                output += entry.getValue() * vec.map.get(entry.getKey());
            }
        }
        return output;
    }
}

