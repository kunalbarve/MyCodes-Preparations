package InterviewExams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TestLiveRamp {

	public int Solution(int[] A, int D) {

		int target = A.length;

		// base case: if can cross the river in one jump.
		if (D - 1 >= target)
			return 0;

		// map which holds this format (time, position)
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < target; i++) {
			if (A[i] != -1)
				map.put(A[i], i);
		}

		// List to keep track of all available positions
		List<Integer> positions = new ArrayList<Integer>();
		positions.add(0);
		for (int time : map.keySet()) {
			int position = map.get(time);
			positions.add(position + 1);
			Collections.sort(positions);

			if (isPossibleToJump(positions, D, target + 1)) {
				return time;
			}
		}
		return -1;
	}
	
	/*
	 Checks below 3 conditions:
	 1) Whether the distance between all possible positions is achievable by monkey (i.e. Less than the given max jump D). If not return false.
	 2) If distance between all positions is valid then whether monkey can cross the river from last available position or not. If not return false.
	 3) If all positions are in coverage & last stone is under D steps from the end of river that is the time when monkey can cross the river so return true. 
	 */
	public boolean isPossibleToJump(List<Integer> positions, int D, int target) {
		for (int i = 1; i < positions.size(); i++) {
			int position = positions.get(i);
			int lastPosition = positions.get(i - 1);
			if (Math.abs(position - lastPosition) > D)
				return false;
		}

		if (Math.abs(positions.get(positions.size() - 1) - target) > D)
			return false;

		return true;
	}

	public static void main(String[] args) {
		int[] A = { 0, 7, 6, 3, 5 };
		TestLiveRamp t = new TestLiveRamp();
		System.out.println("Answer" + t.Solution(A, 1));
		;
	}

}
