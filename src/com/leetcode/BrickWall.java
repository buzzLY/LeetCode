package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null || wall.size() == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; ++i) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				count = Math.max(count, map.get(sum));
			}
		}
		return wall.size() - count;
	}
}