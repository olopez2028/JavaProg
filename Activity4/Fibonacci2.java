/*************************************************************************
 *  Compilation:  javac Fibonacci2.java
 *  Execution:    java Fibonacci2 N
 *  
 *  Computes and prints the first N Fibonacci numbers using the
 *  following recurrence:
 *
 *         f(1) = f(2) = 1
 *         f(n) = f((n+1)/2)^2 + f((n-1)/2)^2   if n is odd
 *         f(n) = f(n/2 + 1)^2 - f(n/2 - 1)^2   if n is even
 *
 *   % java Fibonacci2 7
 *   0
 *   1
 *   1
 *   2
 *   3
 *   5
 *   8
 *   13
 *
 *   Remarks
 *   -------
 *    - The 93rd Fibonacci number would overflow a long
 *
 *************************************************************************/

public class Fibonacci2 {

    public static long fib(int n) {
        // base case
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        //if (n >= 93) throw new RuntimeException("Input out of bounds");

        // n is odd
        if (n % 2 != 0) {
            long a = fib((n+1)/2);
            long b = fib((n-1)/2);
            return a*a + b*b;
        }

        // n is even
        long a = fib(n/2 + 1);
        long b = fib(n/2 - 1);
        return a*a - b*b;
    }

    public static void main(String[] args) {
        int N = 135000; //Integer.parseInt(args[0]);
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i <= N; i++){
        	long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println(i + ": " + fib(i) + " Total computing time: " + totalTime/1000.0 + " seconds.");
        }
               
        long sum = 0;
        for (int i = 0; i <= N; i++)
            sum += fib(i);
        System.out.println(sum);
                
    }

}