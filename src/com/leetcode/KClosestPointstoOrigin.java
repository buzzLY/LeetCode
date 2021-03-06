package com.leetcode;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
		for(int[] p : points) {
			pq.offer(p);
			if(pq.size() > K)
				pq.poll();
		}
		int [][]res = new int[K][2];
		while(K > 0) {
			res[--K] = pq.poll();
		}
		return res;
	}

	public static void main(String[] args) {

	}
}

/*
 * 
 * 
 * class Point { int x, y, distance;
 * 
 * public Point(int x, int y, int distance) { this.x = x; this.y = y;
 * this.distance = distance; }
 * 
 * @Override public String toString() { return "Point [x=" + x + ", y=" + y +
 * "]"; }
 * 
 * }
 * 
 * private int distanceFromOrigin(int x, int y) { return x * x + y * y; }
 * 
 * public int[][] kClosest(int[][] points, int K) { Point[] allPoints = new
 * Point[points.length]; for (int i = 0; i < points.length; i++) { allPoints[i]
 * = new Point(points[i][0], points[i][1], distanceFromOrigin(points[i][0],
 * points[i][1])); } Arrays.sort(allPoints, new Comparator<Point>() {
 * 
 * @Override public int compare(Point o1, Point o2) { return (o1.distance -
 * o2.distance); } }); int[][] output = new int[K][2]; for (int i = 0; i < K;
 * i++) { System.out.println(allPoints[i]); output[i][0] = allPoints[i].x;
 * output[i][1] = allPoints[i].y; } return output; }
 * 
 * public static void main(String[] args) { int[][] points = new int[2][2];
 * points[0][0] = 1; points[0][1] = 3; points[1][0] = -2; points[1][1] = 2; new
 * KClosestPointstoOrigin().kClosest(points, 1); }
 * 
 * 
 */
