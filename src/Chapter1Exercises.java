import java.awt.Color;
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
	
	private long[] Fmemory = new long[1000];
	public long F(int N){
		// initialize Fmemory array to all 0
		for (int i = 0; i < Fmemory.length; i++){
			Fmemory[i] = 0;
		}
		
		// call internalF recursively
		return internalF(N);
	}
	
	private long internalF(int N){
		if (N  == 0)
			return 0;
		else if (N == 1)
			return 1;
		else if (N >0 && Fmemory[N] > 0)
			return Fmemory[N];
		long result = internalF(N-2) + internalF(N -1);
		Fmemory[N] = result;
		return result;
		
	}
	
	//1.1.24
	public int GCD(int p, int q){
		System.out.println(p + " " + q);
		if (q == 0) return p;
		int r = p % q;
		return GCD(q, r);
	}
	
	//1.1.27
	public double binomial(int N, int k, double p){
		if ((N == 0) || (k < 0)) return 1.0;
		return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
		
	}
	
	//1.1.31
	public void randomConn(int N, double p){
		StdDraw.setXscale(0, 1024);
		StdDraw.setYscale(0, 1024);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.circle(512.0, 512.0, 400.0);
		StdDraw.show();	
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
		
		// 1.1.19
		System.out.println("1.1.19 tests");
		System.out.println(ce1.F(995));
		
		// 1.1.24
		System.out.println("1.1.24 tests");
		System.out.println(ce1.GCD(1111111, 1234567));
		
		// 1.1.31
		System.out.println("1.1.31");
		ce1.randomConn(100, 0.01);
	}
	
	private void printArray(int[] a){
		int row = a.length;
		for (int i = 0; i < row; i++){
			System.out.print(a[i] + " ");
			
		}
		System.out.println("");
	}

}
