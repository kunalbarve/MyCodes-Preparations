package Arrays;

public class MatrixRotation extends UtilityArray {

	static void rotateBy90(int[][] matrix){
		for(int layer = 0; layer < (matrix.length)/2 ; layer++){
			int first = layer;
			int last = matrix.length - 1 - layer;
			for(int i = first; i< last; i++){
				int offset = i - first;
				
				int temp = matrix[first][i];
				
				matrix[first][i] = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[i][last];
				
				matrix[i][last] = temp;
			}
		}
	}
	
	static void rotateBy180(int[][] matrix){
		for(int layer = 0; layer < (matrix.length)/2 ; layer++){
			int first = layer;
			int last = matrix.length - 1 - layer;
			for(int i = first; i< last; i++){
				int offset = i - first;
				
				int temp = matrix[first][i];
				
				matrix[first][i] = matrix[last][last-offset];
				
				matrix[last][last-offset] = temp;
				
				int temp2 = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[i][last];
				
				matrix[i][last] = temp2;
			}
		}
	}
	
	static void rotateBy270(int[][] matrix){
		for(int layer = 0; layer < (matrix.length)/2; layer++){
			int first = layer;
			int last = matrix.length - 1 - layer;
			for(int i = first; i< last; i++ ){
				int offset = i - first;
				
				int top = matrix[first][i];
				
				matrix[first][i] = matrix[i][last];
				
				matrix[i][last] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[last-offset][first];
				
				matrix[last-offset][first] = top;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = createMatrix();
		
		printMatrix(matrix);
		rotateBy180(matrix);
		printMatrix(matrix);

	}

}
