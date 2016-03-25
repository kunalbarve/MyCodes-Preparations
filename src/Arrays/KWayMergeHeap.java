package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


//O(nlogk)
public class KWayMergeHeap {

	public List<Integer> merge(List<List<Integer>> list) {
		int size = 0;
		for (List<Integer> subList : list) {
			size += subList.size();
		}
		List<Integer> result = new ArrayList<Integer>(size);
		Queue<Entry> queue = new PriorityQueue<Entry>(size);
		
		for (List<Integer> subList : list) {
			Iterator<Integer> it = subList.iterator();
			if(it.hasNext()) {
				queue.add(new Entry(it.next(), it));
			}
			
		}
		
		System.out.println(queue);
		
		while(!queue.isEmpty()) {
			Entry entry = queue.poll();
			result.add(entry.getValue());
			System.out.println("Result:"+result);
			if (entry.readNext()) {
				queue.add(entry);
			}
			System.out.println();
			System.out.println(queue);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[] { 1, 3, 5, 7, 9 }); 
		List<Integer> list2 = Arrays.asList(new Integer[] { 2, 4, 6, 8, 10 }); 
		List<Integer> list3 = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5 }); 

		List<List<Integer>> lists = new ArrayList<List<Integer>>(); 
		lists.add(list1); 
		lists.add(list2); 
		lists.add(list3); 

		List<Integer> output = new KWayMergeHeap().merge(lists); 
		System.out.println(output);  
	}
	
}

class Entry implements Comparable<Entry> {

	private int value;
	private Iterator<Integer> it;
	
	
	public Entry(int value, Iterator<Integer> it) {
		super();
		this.value = value;
		this.it = it;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Iterator<Integer> getIt() {
		return it;
	}


	public void setIt(Iterator<Integer> it) {
		this.it = it;
	}

	public boolean readNext() {
		if(it.hasNext()) {
			this.value = it.next();
			return true;
		} else {
			return false;
		}
	}
 
	@Override
	public int compareTo(Entry e) {
		return Integer.valueOf(value).compareTo(e.value);
	}
	
	@Override
	public String toString(){
		return ""+value;
	}
	
}