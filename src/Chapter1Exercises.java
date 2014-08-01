
public class Chapter1Exercises {

	public int maxIntToLog(int N){
		if (N <= 0) return 0;
		int result = 0;
		for (result = 0; result * result <= N; result++){}
		
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
		System.out.println(ce1.maxIntToLog(1024));
		System.out.println(ce1.maxIntToLog(1024*1024));

	}

}
