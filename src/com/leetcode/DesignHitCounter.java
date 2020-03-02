package com.leetcode;

public class DesignHitCounter {
	int[] times;
	int[] hits;

	/** Initialize your data structure here. */
	public DesignHitCounter() {
		times = new int[300];
		hits = new int[300];
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		int index = timestamp % 300;
		if (times[index] != timestamp) {
			times[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int output = 0;
		for (int i = 0; i < 300; ++i) {
			if (timestamp - 300 < times[i])
				output += hits[i];
		}
		return output;
	}
}
