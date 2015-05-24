
public class Tribonacci {
	public static long fib(int n) {
		if (n <= 1) return 0;
    	if (n <= 2) return 1;
        else return fib(n-1) + fib(n-2) + fib(n-3);
    }

    public static void main(String[] args) {
        int N = 11; //Integer.parseInt(args[0]);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= N; i++){
        	long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;        	
            System.out.println(i + ": " + fib(i) + " Total computing time: " + totalTime/1000.0 + " secods.");
        }
    }
}
