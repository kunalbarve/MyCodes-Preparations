package StackAndQueue;

import java.util.Stack;

class Tower{
	private Stack<Integer> disk;
	private int index;
	
	public Tower(int i){
		disk = new Stack<Integer>();
		index = i;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void moveTop(Tower destination){
		int top = disk.pop();
		destination.add(top);
		System.out.println("Disk moved from "+getIndex()+" to "+destination.getIndex());
	}
	
	public void add(int data){
		if(!disk.isEmpty() &&  disk.peek() <= data){
			System.out.println("Can't move the disk");
		}else{
			disk.push(data);
		}
	}
	
	public void moveDisk(int diskNo, Tower destination, Tower buffer){
		if(diskNo>=0){
			moveDisk(diskNo-1, buffer, destination);
			moveTop(destination);
			moveDisk(diskNo-1, destination, this);
		}
	}
}

public class TowerOfHanoi {
	public static void main(String[] args){
		int totalTowers = 3;
		int totalDishes = 3;
		Tower[] towers = new Tower[totalTowers];
		for(int i=0; i<3; i++ ){
			towers[i] = new Tower(i);
		}
		
		for(int i = totalDishes-1; i>=0; i--){
			towers[0].add(i);
		}
		
		towers[0].moveDisk(3, towers[1], towers[2]);
	}
}
