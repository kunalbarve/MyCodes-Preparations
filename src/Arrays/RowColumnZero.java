package Arrays;

// If an element in M*N matrix is zero than make it's entire row and column as zero.
// We need Space(MN) but as we are not keeping track of exact element location and just keeping track of row and column no it will take less space.  
import java.util.Random;
public class RowColumnZero extends UtilityArray{
	
	static void makeRowColumnZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i =0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length; j++){
					if(matrix[i][j] == 0){
						row[i] = true;
						column[j] = true;
					}
			}
		}
		
		for(int i =0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length; j++){
					if(row[i] || column[j])
						matrix[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args){
		Random randomGenerator = new Random();
		int[][] matrix = new int[5][3];
		for(int i =0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length; j++){
				matrix[i][j] = randomGenerator.nextInt(9);
			}
		}
		printMatrix(matrix);
		makeRowColumnZero(matrix);
		System.out.println();
		printMatrix(matrix);
	}
}