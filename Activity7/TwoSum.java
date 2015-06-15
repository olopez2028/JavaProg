/*************************************************************************
 *  Compilation:  javac TwoSum.java
 *  Execution:    java TwoSum < input.txt
 *                java N Generator | java TwoSum
 *
 *  A program with cubic running time. Read in N integers
 *  and counts the number of pairs that sum to exactly 0.
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

public class TwoSum {

    // print distinct pairs (i, j) such that a[i] + a[j]  = 0
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    } 

    // return number of distinct triples (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[i] + a[j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    } 

    public static void main(String[] args)  { 
        int N = StdIn.readInt(); 
        int[] a = new int[N]; 
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        }

        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(cnt);
    } 
} 
