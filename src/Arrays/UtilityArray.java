package Arrays;

public class UtilityArray {
	
	static void printMatrix(int[][] matrix){
		System.out.println();
		for(int i=0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int[][] createMatrix(){
		int no = 1;
		int[][] matrix = new int[4][4];
		
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				matrix[i][j] = no;
				no++;
			}
		}
		return matrix;
	}
}
