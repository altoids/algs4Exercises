import java.util.Random;


public class Matrix {

	// matrix multiply using arrays
	public int[][] mmultiply(int[][] a, int[][] b){
		int N = a.length;
		int[][] c = new int[N][N];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				int sum = 0;
				for (int k = 0; k< N; k ++){
					sum = sum + a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}
	
	public int[][] transposition(int[][] a){
		int row = a.length;
		int column = a[0].length;
		int[][] b = new int[column][row];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix mmp = new Matrix();
		int row = 3;
		int column = 4;
		Random rm = new Random();
		int[][] a = new int[row][column];
		int[][] b = new int[row][column];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				a[i][j] = rm.nextInt(10);
				b[i][j] = rm.nextInt(10);
			}
		}
		
		mmp.printArray(a);
		//mmp.printArray(b);		
		//mmp.printArray(mmp.mmultiply(a, b));
		
		mmp.printArray(mmp.transposition(a));
		
	}
	
	private void printArray(int[][] a){
		int row = a.length;
		int column = a[0].length;
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
