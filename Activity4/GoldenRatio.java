/*************************************************************************
 *  Compilation:  javac GoldenRatio.java
 *  Execution:    java GoldenRatio N
 *  
 *  Computes an approximation to the golden ratio using the recursive
 *  formula f(0) = 1, f(n) = 1 + 1 / f(n-1) if n > 0.
 *
 *  % java GoldenRatio 5
 *  1.625
 *
 *  % java GoldenRatio 10
 *  1.6179775280898876
 *
 *  % java GoldenRatio 20
 *  1.618033985017358
 *
 *  % java GoldenRatio 30
 *  1.6180339887496482
 *
 *************************************************************************/

class GoldenRatio {
   public static double golden(int n) {
       if (n == 0) return 1;
       return 1.0 + 1.0 / golden(n-1);
   }
   
   public static long fib(int n) {
       if (n <= 1) return n;
       else return fib(n-1) + fib(n-2);
   }
   
   public static double goldenratio(int n){
   	return fib(n+1)*Math.pow(fib(n),-1);
   }

   public static void main(String[] args) {
      int N = 30;//Integer.parseInt(args[0]);
      //System.out.println(golden(N));
                
      System.out.println(goldenratio(N));
   }

}
