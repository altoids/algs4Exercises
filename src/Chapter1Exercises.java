import java.util.Random;


public class Chapter1Exercises {

	//1.1.14
	public int maxIntToLog(int N){
		if (N <= 1) return 0;
		int result = 0;
		int powof2 = 4;
		for (result = 2; powof2 <= N; result++){powof2 = 2 * powof2;}
		
		return result == 0? 0: result -1;
		
	}
	
	//1.1.15
	public int[] histgram(int[] a, int M){
		int[] result = new int[M];
		for (int i = 0; i< a.length; i++){
			result[a[i]] += 1;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1Exercises ce1 = new Chapter1Exercises();
		// tests for maxIntToLog
		System.out.println("1.1.14 tests");
		System.out.println(ce1.maxIntToLog(-1));
		System.out.println(ce1.maxIntToLog(-2));
		System.out.println(ce1.maxIntToLog(0));
		System.out.println(ce1.maxIntToLog(1));
		System.out.println(ce1.maxIntToLog(2));
		System.out.println(ce1.maxIntToLog(4));
		System.out.println(ce1.maxIntToLog(1024*5));
		System.out.println(ce1.maxIntToLog(1024*1024+3));

		// 1.1.15 tests
		System.out.println("1.1.15 tests");
		int M = 100;
		Random rm = new Random();
		int[] a= new int[M];
		for (int i = 0; i<M; i++){
			a[i] = rm.nextInt(M-1);
		}
		ce1.printArray(a);
		ce1.printArray(ce1.histgram(a, M));
	}
	
	private void printArray(int[] a){
		int row = a.length;
		for (int i = 0; i < row; i++){
			System.out.print(a[i] + " ");
			
		}
		System.out.println("");
	}

}
