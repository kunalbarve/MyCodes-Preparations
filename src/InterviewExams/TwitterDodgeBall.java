package InterviewExams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwitterDodgeBall {

	List<List<Integer>> ans = new ArrayList<>();

	static HashMap<Integer, List<List<Integer>>> hashmap = new HashMap<>();

	static void powerset(List<Integer> src) {
		powerset(new ArrayList<>(), src);
	}

	private static void powerset(List<Integer> prefix, List<Integer> src) {
		if (src.size() > 0) {
			prefix = new LinkedList<>(prefix); // create a copy to not modify
												// the orig
			src = new ArrayList<>(src); // copy
			
			System.out.println("Prefix"+prefix);
			System.out.println("SRC"+src);
			Integer curr = src.remove(0);
			collectResult(prefix, curr);
			powerset(prefix, src);
			prefix.add(curr);
			powerset(prefix, src);
		}
	}

	private static void collectResult(List<Integer> prefix, Integer curr) {
		prefix = new ArrayList<>(prefix); // copy
		prefix.add(curr);
		List<List<Integer>> addTo;
		if (hashmap.get(prefix.size()) == null) {
			List<List<Integer>> newList = new ArrayList<>();
			addTo = newList;
		} else {
			addTo = hashmap.get(prefix.size());
		}
		addTo.add(prefix);
		hashmap.put(prefix.size(), addTo);
		System.out.println("HashMap: "+hashmap);
	}

	static int dodgeBall(int n) {
		List<Integer> src = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			src.add(i);
		}
		powerset(src);
		System.out.println(hashmap);
		return getSolution(n);
	}

	public static int getSolution(int n) {
		int k = 0;
		for (int i = 2; i <= n; i++) {
			List<List<Integer>> list = hashmap.get(i);
			System.out.println(list);
			boolean result = isFightPossible(list);
			if (result) {
				return i;
			}
		}
		return k;
	}

	static boolean isFightPossible(List<List<Integer>> list) {
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			List<Integer> inner = list.get(i);
			boolean result = false;
			for (int k = 1; k < inner.size(); k++) {
				int first = inner.get(0);
				int second = inner.get(k);
				result = isEvenlyDivided(first, second);
				if (result)
					break;
				System.out.println("First:" + first + " Second: " + second + " Result : " + result);
			}
			if(result)
				temp++;
		}
		System.out.println(temp);

		if (temp == list.size())
			return true;
		return false;
	}

	static boolean isEvenlyDivided(int a, int b) {
		if (a % b == 0 || b % a == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dodgeBall(3));
	}

}
