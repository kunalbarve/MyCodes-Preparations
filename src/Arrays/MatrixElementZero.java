package Arrays;

public class MatrixElementZero extends UtilityArray{
	
	static int countInRows(int[][] input, int item, int i, int j){
		int count = 1;
		while(j+1 < input[i].length){
			int next = input[i][++j];
			if(item == next)
				count++;
            else break;
		}
		return count;
	}
	
	static int countInColumns(int[][] input, int item, int i, int j){
		int count = 1;
		while(i+1 < input.length){
			int next = input[++i][j];
			if(item == next)
				count++;
            else break;
		}
		return count;
	}
	
	static void makeZero(int[][] temp, int count, int i, int j, boolean flag){
		while(count != 0){
			if(flag){
				temp[i][j++] = 0;
			}else{
				temp[i++][j] = 0;
			}
			count--;
		}
	}
	
	static int[][] updateMatrix(int[][] input){
		int rows = input.length;
		int columns = input[0].length;
		int[][] temp = new int[rows][columns];
		
		for(int i = 0; i< rows; i++){
			for(int j = 0; j< columns; j++){
				temp[i][j] = input[i][j];
			}
		}
		
		for(int i = 0; i< rows; i++){
			for(int j = 0; j< columns; j++){
				int current = input[i][j];
				int rowResult = countInRows(input, current, i ,j);
				int columnResult = countInColumns(input, current, i ,j);
				if(rowResult >= 3)
					makeZero(temp, rowResult, i, j, true);
				if(columnResult >= 3)
					makeZero(temp, columnResult, i, j, false);
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		int[][] input = new int[3][6];
		input[0][0] = 1;
		input[0][1] = 2;
		input[0][2] = 2;
		input[0][3] = 2;
		input[0][4] = 3;
		input[0][5] = 4;
		input[1][0] = 1;
		input[1][1] = 2;
		input[1][2] = 3;
		input[1][3] = 4;
		input[1][4] = 5;
		input[1][5] = 6;
		input[2][0] = 1;
		input[2][1] = 2;
		input[2][2] = 3;
		input[2][3] = 4;
		input[2][4] = 5;
		input[2][5] = 6;
		
		printMatrix(input);
		
		int[][] result = updateMatrix(input);
		printMatrix(result);
	}

}
