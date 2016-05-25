package InterviewExams;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirstAmazon {

	public class process implements Comparator<process> {
		int duration;
		int requestTime;

		public process(int requestTime, int duration) {
			this.duration = duration;
			this.requestTime = requestTime;
		}

		@Override
		public int compare(process p1, process p2) {
			if (p1.duration == p2.duration)
				return p1.requestTime - p2.requestTime;
			return p1.duration - p2.duration;

		}
	}

	public float waitingTimeSJF(int[] req, int[] dur) {

		if (req == null || dur == null || req.length != dur.length)
			return 0;

		int index = 0, length = req.length;
		int waitTime = 0, curTime = 0;

		PriorityQueue<process> pq = new PriorityQueue<process>();

		while (!pq.isEmpty() || index < length) {
			if (!pq.isEmpty()) {
				process cur = pq.poll();
				waitTime += curTime - cur.duration;
				curTime += cur.duration;
				while (index < length && curTime >= req[index])
					pq.add(new process(req[index], dur[index++]));
			} else {
				pq.add(new process(req[index], dur[index]));
				curTime = req[index++];
			}
		}
		return (float) waitTime / length;
	}

	public static void main(String[] args) {

	}

}
