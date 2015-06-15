
public class RandomPermutation {
	public static void main(String[] args) {
	
		int N = 100; //Integer.parseInt(args[0]);
		
		int[] a = new int[N]; 
		boolean[] taken = new boolean[N]; 
		int count = 0; 
		while (count < N) 
		{ 
		   int r = StdRandom.uniform(N); 
		   if (!taken[r]) 
		   { 
		       a[r] = count; 
		       taken[r] = true; 
		       count++;
		       
		       StdOut.println(a[r]);
		   } 
		} 
	}
}
