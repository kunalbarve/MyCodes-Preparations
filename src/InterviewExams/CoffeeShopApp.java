package InterviewExams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CoffeeShopApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double userY = Double.parseDouble(sc.next());
		double userX = Double.parseDouble(sc.next());
		String fileName = sc.next();
		
		sc.close();
		
		Point origin = new Point(userX, userY);
		
		Collection<Point> locations = generateLocationDetails(fileName, origin);
		
		Collection<Point> closestShops = getClosestShops(locations, 3);
		
		List<Point> result = new ArrayList<>();
		result.addAll(closestShops);
		Collections.reverse(result);
		for(Point closestLocation: result){
			closestLocation.printOutput();
		}
	}

	private static Collection<Point> getClosestShops(Collection<Point> locations, int maxShops) {
		PriorityQueue<Point> queue = new PriorityQueue<>(maxShops);
		for(Point location: locations){
			 if (queue.size() < maxShops) {
	                queue.add(location);
	            } else {
	                if (queue.peek().compareTo(location) < 0) {
	                    queue.poll();
	                    queue.add(location);
	                }
	            }
		}
		return queue;
	}

	private static Collection<Point> generateLocationDetails(String fileName, Point origin) {
		Collection<Point> locations = new ArrayList<Point>(); 
		try {
	            String line = "";
	            URL url = CoffeeShopApp.class.getResource(fileName);
	            File file = new File(url.getPath());
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                String[] st = line.split(",");
                	String name = st[0];
                	double locationY = Double.parseDouble(st[1]);
                	double locationX = Double.parseDouble(st[2]);
                	Point point = new Point(locationX, locationY, name, origin);
	                locations.add(point);
	            }   
	            bufferedReader.close();
	            fileReader.close();
	            
	        }
	        catch(FileNotFoundException ex) {
	        	System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	        }
		return locations;
	}

}

class Point implements Comparable<Point> {
    double x, y;
    String placeName;
    double dist;

    public Point(double x, double y, String placeName, Point originPoint) {
        this.x = x;
        this.y = y;
        this.placeName = placeName;
        double result = Math.hypot(x - originPoint.x, y - originPoint.y); 
        DecimalFormat df = new DecimalFormat("#.####");
        this.dist = Double.valueOf(df.format(result));
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point that) {
        return Double.valueOf(that.dist).compareTo(dist);
    }

    @Override
    public String toString() {
        return "(" + x + " , " + y+")";
    }
    
    public void printOutput(){
    	System.out.println(placeName+","+dist);
    }
}
