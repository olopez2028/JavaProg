public class Exponential {

    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);

        // read in input data
        long[] a = new long[N];
        for (int i = 0; i < N; i++)
            a[i] = StdIn.readLong();

        // find subset closest to 0
        long best = Long.MAX_VALUE;
        for (int n = 1; n < (1 << N); n++)  {
            long sum = 0;
            for (int i = 0; i < N; i++) 
                if (((n >> i) & 1) == 1) sum = sum + a[i];
            if (Math.abs(sum) < Math.abs(best)) best = sum;
        }
        System.out.println(best);


    }

}