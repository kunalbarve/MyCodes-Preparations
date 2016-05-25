package InterviewExams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Holder class for Video 
class Video {
	String videoId;
	int views;

	public Video(String videoId, int views) {
		this.videoId = videoId;
		this.views = views;
	}

	public String getvideoId() {
		return videoId;
	}

	public void setvideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
}

public class AmazonMostViewed {
	// Contains the data about videos existing in the system
	public static HashMap<String, Video> videoLibrary = new HashMap<String, Video>();
	// LinkedList structure that is updated whenever a video is viwed.
	// Top viewed video is stored at the head of the linkedList.
	public static List<Video> videoViews = new LinkedList<>();

	List<String> getTopVideos() {
		List<String> l = new ArrayList<>(10);
		for (int i = 0; i < 10 && i < videoViews.size(); i++)
			l.add(videoViews.get(i).getvideoId());
		return l;
	}

	// Private method used to add video to the library
	private void addVideo(String id) {
		if (videoLibrary.containsKey(id))
			return;
		else {
			Video v = new Video(id, 0);
			videoLibrary.put(id, v);
		}
	}

	void videoViewed(String videoId) {

		if (videoLibrary.get(videoId) == null) {
			addVideo(videoId);
		}
		Video v = (Video) videoLibrary.get(videoId);
		if (!videoViews.contains(v)) {
			v.views++;
			videoViews.add(videoViews.size(), v);
		} else {
			int currentindex = videoViews.indexOf(v);
			while (currentindex > 0 && v.views == videoViews.get(currentindex - 1).views) { // If
																							// the
																							// neighbouring
																							// elements
																							// have
																							// the
																							// same
																							// number
																							// views,
																							// find
																							// the
																							// next
																							// position
																							// to
																							// place
																							// the
																							// video
				currentindex--;
			}
			videoViews.remove(v);
			v.views++;
			videoViews.add(currentindex, v);
		}
		videoLibrary.put(videoId, v);
	}

	int getRanking(String videoId) {
		Video v = videoLibrary.get(videoId);
		if (!videoViews.contains(v)) {
			return videoViews.size() + 1; // The video for which you are
											// checking the rank has never been
											// viewed. Hence its rank will the
											// least.
		} else {
			return videoViews.indexOf(v) + 1; // Adding 1 to the index as index
												// starts from 0
		}
	}

	public static void main(String[] args) {

		AmazonMostViewed s = new AmazonMostViewed();

		s.videoViewed("Video1");
		s.videoViewed("Video2");
		s.videoViewed("Video2");
		s.videoViewed("Video3");
		s.videoViewed("Video1");
		s.videoViewed("Video1");

		List<String> result = s.getTopVideos();

		for (int i = 0; i < result.size(); i++) {
			System.out.println((i + 1) + ". " + result.get(i));
		}

		System.out.println("Rank of Video 1 is " + s.getRanking("Video1"));

	}
}

/*

Assumptions :

1. I have assumed that videoViewed list is initially empty.
Hence I am adding the video to library so that we do not have search the linkedList to find the video.

2. This approach works well with more number of videos in the system and less number of videos have the same number of views.


Approach :

1. Approach for getTopVideos() : Top 10 videos are the first 10 videos starting from the head of the linkedList. Hence we get the top 10 videos in constant time.

2. Approach for getRanking() : As the linkedList is already sorted on the basis of the number of views, index of each video in the given list gives us the ranking of the video.

3. Approach for videoViewed(): I am keeping the linked list sorted whenever a video is viewed. So a newly viewed video would be stored at the tail of the linkedList. I avoided the use of regular list, as the approach requires continuous swapping and shifting of the objects in the list.


TimeComplexity : 

The time complexity for finding top videos is O(1) as the top videos are nearest to the head.

The time complexity for getRanking is O(N).

The time complexity for viewVideos is O(N).


Additional Data Structures :

1. Purpose of using linkedList 
I am using linkedList so that I can leverage upon the basic characteristics of linkedList that changes in the existing node structure can be achieved in constant time after each and every view operation.

2. Purpose of using hashMap 
I am using hashMap to maintain a library for videos so that a particular video can be fetched in constant time (O(1))
I am using hash map for fetching the video details from the 

*/