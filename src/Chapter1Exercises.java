import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
		double cx = 512.0;
		double cy = 512.0;
		double r = 500.0;
		Draw d = new Draw();
		d.setXscale(0, 1024);
		d.setYscale(0, 1024);
		d.setPenColor(Color.BLACK);
		d.circle(cx, cy, r);
		d.show();	
		d.setPenRadius(0.005);
		double x = 0.0;
		double y = 0.0;
		double x1 = 0.0;
		double y1 = 0.0;
		for (double a = 0.0; a <= 2 * Math.PI; a += 2 * Math.PI/N){
			x = cx + r * Math.cos(a);
			y = cy + r * Math.sin(a);
			x1 = cx + r * Math.cos(Math.PI + a);
			y1 = cy + r * Math.sin(Math.PI + a);
			d.setPenColor(Color.BLACK);
			d.point(x, y);
			d.point(x1, y1);
			if (StdRandom.bernoulli(p)){
				d.setPenColor(Color.GRAY);
				d.line(x, y, x1, y1);
			}
		}
	}
	
	//1.1.33
	public double dot(double[] x, double[] y){
		if (x.length != y.length)
			return 0.0;
		double result = 0.0;
		for (int i = 0; i < x.length; i++){
			result += x[i] * y[i];
		}
		return result;
	}
	
	// 1.1.36
	// key is to keep the random range at [i, N]
	public void shuffle(double[] a){
		int N = a.length;
		for (int i = 0; i < N; i++){
			int r = i + StdRandom.uniform(N-i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	//1.2.1
		public class Point implements Comparable<Point>{
			private double x;
			private double y;
			private Point(double inX, double inY){
				this.x = inX;
				this.y = inY;
			}
			
			public int compareTo(Point that){
				if (this.x > that.x || this.y > that.y)
					return 1;
				else if (this.x == that.x && this.y == that.y)
					return 0;
				else return -1;
			}
		}
		public void drawClosestDistance(int N){
			// generate N random points
			Point[] points = new Point[N];
			for (int i = 0; i<N; i++){
				points[i] = new Point(StdRandom.uniform(), StdRandom.uniform());
			}
			//calculate and store distrances
			double[][] distances = new double[N][N];
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){
					distances[i][j] = Math.pow(points[i].x-points[j].x, 2) + Math.pow(points[i].y-points[j].y, 2); 
					distances[j][i] = distances[i][j];
					
				}
			}
			Draw d = new Draw();
			d.setXscale();
			d.setYscale();
			d.show();
			for (int i = 0; i< N; i++){
				int minj = 0;
				for (int j = 0; j < N; j++){
					if (distances[i][minj] > distances[i][j] && i != j)
						minj = j;
				}
				//point i to point minj draw a line
				d.line(points[i].x, points[i].y, points[minj].x, points[minj].y);
			}
		}

		// 1.2.2 interval1d
		public class Interval implements Comparable<Interval>{
			public double start;
			public double end;
			
			public Interval(double start, double end){
				this.start = start;
				this.end = end;
			}
			public int compareTo(Interval that){
				if (this.start - that.start > 0.0)
					return 1;
				else if (this.start - that.start < 0.0)
					return -1;
				else return 0;
			}
			
			public String toString(){
				return "(" + start + "," + end + ")";
			}
		}
		
		public void Interval1DSearch(int N){
			// generate N random intervals
			Interval[] intervals = new Interval[N];
			Draw d = new Draw();
			d.setXscale(0,1);
			d.setYscale(0,1);
			d.show();
			for (int i = 0; i< N; i++){
				double start = StdRandom.uniform();
				intervals[i] = new Interval(start,StdRandom.uniform(start,1));
			}
			
			//sort the intervals according to starting point
			Arrays.sort(intervals);
			
			//for each interval i, do a range search in the sorted interval array between i.start and i.end
			for (int i = 0; i< N; i++){
				d.line(intervals[i].start, (1/(double)N)*i, intervals[i].end, (1/(double)N)*i);
				double currentend = intervals[i].end;
				int j = i+1;
				while (j < N && intervals[j].start <= currentend) j++;
				System.out.print(intervals[i] + ";");
				for (int k = i + 1; k<j; k++)
					System.out.print(intervals[k] + ";");
				System.out.println("");
			}
		}
		
		public boolean isCircular(String a, String b){
			String temp = "";
			if (a.length() != b.length() || a.isEmpty() || b.isEmpty())
				return false;
			for (int i = 0; i< a.length(); i++){
				int bindex = b.indexOf(a.charAt(i));
				while (bindex != -1){
					temp = b.substring(bindex) + b.substring(0, bindex);
					if (a.equals(temp))
						return true;
					else
						bindex = b.indexOf(a.charAt(i), bindex + 1);
				}
			}
			return false;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1Exercises ce1 = new Chapter1Exercises();
		/*
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
		ce1.randomConn(1000, 0.01);
		*/
		
		// 1.2.1
		//ce1.drawClosestDistance(15000);
		
		// 1.2.2
		//ce1.Interval1DSearch(50);
		
		// 1.2.4
		/*String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		StdOut.println(string1);
		StdOut.println(string2);
		*/
		
		// 1.2.5
		/*String s = "Hello World";
		s.toUpperCase();
		s.substring(6, 11);
		StdOut.println(s);
		*/
		
		// 1.2.6
		/*String a = "ACTGACG";
		String b = "TGACGAC";
		System.out.println(a);
		System.out.println(b);
		System.out.println(ce1.isCircular(a, b));
		*/
		
		// 1.2.7
		// return string reversed.
		
		
	}
	
	private void printArray(int[] a){
		int row = a.length;
		for (int i = 0; i < row; i++){
			System.out.print(a[i] + " ");
			
		}
		System.out.println("");
	}

}
