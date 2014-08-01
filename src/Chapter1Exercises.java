
public class Chapter1Exercises {

	//1.1.14
	public int maxIntToLog(int N){
		if (N <= 1) return 0;
		int result = 0;
		int powof2 = 4;
		for (result = 2; powof2 <= N; result++){powof2 = 2 * powof2;}
		
		return result == 0? 0: result -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1Exercises ce1 = new Chapter1Exercises();
		// tests for maxIntToLog
		System.out.println(ce1.maxIntToLog(-1));
		System.out.println(ce1.maxIntToLog(-2));
		System.out.println(ce1.maxIntToLog(0));
		System.out.println(ce1.maxIntToLog(1));
		System.out.println(ce1.maxIntToLog(2));
		System.out.println(ce1.maxIntToLog(4));
		System.out.println(ce1.maxIntToLog(1024*5));
		System.out.println(ce1.maxIntToLog(1024*1024+3));

	}

}
