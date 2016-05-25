package InterviewExams;

import java.util.*;

public class AmazonVideos {
	
	// Number of views for particular Video, it will be stored on index in the sequence video arrives. That index is mapped using hashmap
	ArrayList<Integer> view;
	
	// Rank of a particular Video, it will be stored on index in the sequence video arrives. That index is mapped using hashmap
	ArrayList<Integer> rank;
	
	// HashMap which will map a particular video id to the index used in view and rank list. 
	HashMap<String, Integer> hash; 
	
	//Linked List which will store video Id but the head will have the video id with the topmost rank. 
	List<String> videoRankList;
	
	public AmazonVideos(){
		view = new ArrayList<>();
		rank = new ArrayList<>();
		hash = new HashMap<>();
		videoRankList = new LinkedList<>();
	}
	
	/* If video doesn't exist then it will be added to map. 
	Views will be initially 1. 
	Rank will be one plus to the last rank in the rank list.
	It will be added to the map with id and index (i.e. position in view and rank list)
	It will be added last to the videoRankList as that's the video with least rank*/
	void add(String x){
		int s = rank.size();
		view.add(1);
		rank.add(s+1);
		videoRankList.add(x);
		hash.put(x, s);	
	}
	
	// Get ranking of a particular Video in O(1) time.
	int getRanking(String id){
		return rank.get(hash.get(id));
	}
	
	// View a video, when called if video doesn't exist yet then add it otherwise update the rank and increase the views.
	void viewVideo(String id){
		if(!hash.containsKey(id)){
			add(id);
		}else{
			updateRank(id);
			int oldViews = view.get(hash.get(id));
			view.set(hash.get(id), oldViews+1);
		}
		printAll();
	}
	
	// Top 10 videos are the first 10 videos in videoRankList as that list is already sorted on the basis of rank. This will happen on O(1) time.
	List<String> getTopVideos(){
		List<String> ret = new ArrayList<>();
		int i = 0;
		for(i=0; i<10 && i<videoRankList.size(); i++){
			ret.add(videoRankList.get(i));
		}
		return ret;
	}
	
	// Get number of views for a particular video id
	int getNumberOfViews(String id){
		int index = hash.get(id);
		return view.get(index);
	}
	
	//Change rank of a particular video in rank list.
	void changeRanking(String id, int newRank){
		int index = hash.get(id);
		rank.set(index, newRank);
	}

	// Get old views for current video id and shift it to the left in videoRankList till the other videos have same views.
	// Increase the rank of all the videos by one that we are passing by while going to left
	// And finally update the ranking of current video in rankList so that we can access rank of any video in O(1) time.
	// This will take O(n) time in worst case where n is the size of the videoRankList, because we are searching an element in Linked List.
	void updateRank(String id) {
		int currentViews = getNumberOfViews(id);
		int currentIndex = videoRankList.indexOf(id);
		
		while (currentIndex > 0 && currentViews == getNumberOfViews(videoRankList.get(currentIndex-1))) {
			String tempId = videoRankList.get(currentIndex-1);
			changeRanking(tempId, currentIndex+1);
			currentIndex--;
		}

		videoRankList.remove(id);
		videoRankList.add(currentIndex, id);
		changeRanking(id, currentIndex+1);
	}
	
	
	
	void printAll(){
		System.out.println("VIEWS: " + view);
		System.out.println("RANK: " + rank);
		System.out.println("HASH:"+hash);
		System.out.println("RANK LIST:"+videoRankList);
		System.out.println();
	}

	public static void main(String[] args) {
		
		AmazonVideos v = new AmazonVideos();
		
		for(int i=1;i<=5;i++)
			v.viewVideo("500");
		for(int i=1;i<=2;i++)
			v.viewVideo("200");
		for(int i=1;i<=3;i++)
			v.viewVideo("300");
		for(int i=1;i<=4;i++)
			v.viewVideo("400");

		System.out.println(v.getRanking("400"));
		
		System.out.println(v.getTopVideos());
	}

}

