
public class Chapter1Exercises {

	public int maxIntToLog(int N){
		if (N <= 1) return 0;
		int result = 0;
		int initial = 2;
		for (result = 2; initial <= N; result++){initial = 2 * initial;}
		
		return result == 0? 0: result -2;
		
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
