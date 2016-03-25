package DynamicProgramming;

import java.util.*;

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}

public class RobotOnGrid {

	//-----------------------------------------------------------------------------------------
	// Robot is on x,y find no of paths from x,y to origin
	
	static int findFactorial(int no){
		int result = 1;
		for(int i = 2; i<= no; i++){
			result = result*i;
		}
		return result;
	}
	
	// (x+y)!/x!y!
	static int noOfPaths(int x, int y){
		int result = (findFactorial(x+y))/(findFactorial(x)*findFactorial(y));
		return result;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	// Find a single path (There is no best path as each path must come down by Y steps and come left by x steps).
	// Also consider the points in blocks that a robot can't cross.
	
	static ArrayList<Point> blocks = new ArrayList<>();
	
	static boolean isFree(int x, int y){
		for(Point p: blocks){
			if(p.getX() == x && p.getY() == y ){
				return false;
			}
		}
		return true;
	}
	
	static boolean getPaths(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache){
		Point p = new Point(x,y);
		
		if(cache.containsKey(p))
			return cache.get(p);
		
		if(x == 0 && y == 0)
			return true;
		
		boolean success = false;
		if(x >=1 && isFree(x-1, y)){
			success = getPaths(x-1, y, path, cache);
		}
		if(!success && y >=1 && isFree(x, y-1)){
			success = getPaths(x, y-1, path, cache);
		}
		
		if(success)
			path.add(p);
		
		cache.put(p, success);
		return success;
	}
	
	//-----------------------------------------------------------------------------------------
	
	public static void main(String[] args){
//		System.out.println("No of paths"+noOfPaths(3, 1));
	
		blocks.add(new Point(0, 2));
		blocks.add(new Point(1, 0));
		
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		ArrayList<Point> path = new ArrayList<>();
		
		if(getPaths(2, 2, path, cache)){
			for(Point p: path){
				System.out.print(p.toString()+" -> ");
			}
		}else{
			System.out.println("No Path Found");
		}
		
	}
	
}
