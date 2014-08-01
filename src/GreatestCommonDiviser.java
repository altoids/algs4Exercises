import java.io.Console;


public class GreatestCommonDiviser {

	public int GCD(int p, int q){
		if (q == 0) return p;
		int r = p % q;
		return GCD(q, r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreatestCommonDiviser gcd = new GreatestCommonDiviser();
		System.out.println(gcd.GCD(1, 100));
		System.out.println(gcd.GCD(200,100));
		System.out.println(gcd.GCD(23458944,24));
		
	}

}
