package InterviewExams;

/*import java.util.*;

public class PhoneKeyPadUber {

	HashMap<String, List<String>> map = new HashMap<>();
	StringBuilder sb = new StringBuilder();

	void initiateMap() {
		map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
		map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
		map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
		map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
		map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
		map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
		map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
		map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
	}

	List<String> getAllSolution(List<List<String>> input) {
		if (input == null)
			return null;

		if (input.size() == 1)
			return input.get(0);

		List<String> first = input.get(0);
		input.remove(0);

		List<String> second = getAllSolution(input);
		List<String> result = new ArrayList<>();

		for (String s1 : first) {
			for (String s2 : second) {
				sb.append(s1);
				sb.append(s2);
				result.add(sb.toString());
				sb.setLength(0);
			}
		}
		return result;
	}

	List<String> getInput(String s) {

		List<List<String>> input = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (c >= 48 && c <= 57) {
				String temp = String.valueOf(c);
				if (map.containsKey(temp)) {
					List<String> tempList = map.get(temp);
					input.add(tempList);
				} else {
					List<String> tempList = new ArrayList<>();
					tempList.add(temp);
					input.add(tempList);
				}
			}
		}

		List<String> solution = getAllSolution(input);
		return solution;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();

		PhoneKeyPadUber sol = new PhoneKeyPadUber();
		sol.initiateMap();

		if (s != null && !s.isEmpty()) {
			List<String> solution = sol.getInput(s);
			System.out.println("Result:" + solution);
		}

	}
}
*/

//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class ShortestJobFirst {
//    public float Solution(int[] req, int[] dur) {
//        if (req == null || dur == null || req.length != dur.length)
//            return 0;
//        int index = 0, length = req.length;
//        int waitTime = 0, curTime = 0;
//        PriorityQueue<process> pq = new PriorityQueue<process>(new Comparator<process>() {
//            @Override
//            public int compare(process p1, process p2) {
//                if (p1.exeTime == p2.exeTime)
//                    return p1.arrTime - p2.arrTime;
//                return p1.exeTime - p2.exeTime;
//            }
//        });
//        while (!pq.isEmpty() || index < length) {
//            if (!pq.isEmpty()) {
//                process cur = pq.poll();
//                waitTime += curTime - cur.arrTime;
//                curTime += cur.exeTime;
//                while (index < length && curTime >= req[index])
//                    pq.offer(new process(req[index], dur[index++]));
//            }
//            else {
//                pq.offer(new process(req[index], dur[index]));
//                curTime = req[index++];
//            }
//        }
//        return (float) waitTime / length;
//    }
//}