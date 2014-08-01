
public class PrimeNumber {

	public boolean isPrime(int N){
		if (N < 2) return false;
		for (int i = 2; i*i <= N; i++){
			if (N % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber pn = new PrimeNumber();
		for (int i = 0; i < 10000; i++ ){
			if (pn.isPrime(i))
				System.out.println(i + " isPrime! ");
		}
	}

}
