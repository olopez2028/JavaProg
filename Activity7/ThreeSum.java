/*************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum < input.txt
 *                java N Generator | java ThreeSum
 *
 *  A program with cubic running time. Read in N integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  % java ThreeSum < 8ints.txt 
 *  4
 *  30 -30 0
 *  30 -20 -10
 *  -30 -10 40
 *  -10 0 10
 *
 *  % java ThreeSum < 1Kints.txt
 *  0
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *  Sample data files
 *  -----------------
 *  http://www.cs.princeton.edu/introcs/41analysis/8ints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/1Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/2Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/4Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/8Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/16Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/32Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/64Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/128Kints.txt
 *
 *  Use the program Generator.java to generate additional data files.
 *
 *************************************************************************/

public class ThreeSum {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 
    
    
    //find triple of numbers on standard input whose sum is closest to X
    public static void TripleNumbersClosestToX(int x, int[] a){
    	int N = a.length;
    	for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                	if (a[i] + a[j] + a[k] == x) {
                		StdOut.println("(" + a[i] + ") + (" + a[j] + ") + (" + a[k] + ") = " + x);
                    }
                }
            }
        }
    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    } 

    public static void main(String[] args)  { 
    	
    	int x = Integer.parseInt(args[0]);
    	
    	System.out.println("Entered number = " + x);   
    	
    	int N = StdIn.readInt(); 
        int[] a = new int[N]; 
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        }        
    	 
        Stopwatch timer = new Stopwatch();
        
        TripleNumbersClosestToX(x, a);
        
        StdOut.println("elapsed time = " + timer.elapsedTime());             
    } 
} 