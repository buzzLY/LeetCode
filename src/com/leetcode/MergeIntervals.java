package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
}

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null)
			return null;
		if (intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start)
					return -1;
				if (o1.start > o2.start)
					return 1;
				if (o1.start == o2.start) {
					if (o1.end == o2.end)
						return 0;
					if (o1.end < o2.end)
						return -1;
					if (o1.end > o2.end)
						return 1;
				}
				return 0;
			}
		});
		List<Interval> answer = new ArrayList<>();

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval in : intervals) {
			if (in.start <= end) { // i overlap with the previous one.
				end = Math.max(end, in.end);
			} else {
				answer.add(new Interval(start, end));
				start = in.start;
				end = in.end;
			}
		}
		answer.add(new Interval(start, end));
		return answer;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		List<Interval> result = MergeIntervals.merge(intervals);
		for (Interval in : result) {
			System.out.println(in);
		}
	}

}