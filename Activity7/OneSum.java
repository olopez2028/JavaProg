public class OneSum {

    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);

        // read in input data
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        }

        // find pair whose sum is closest to 0
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = a[i];
            if (Math.abs(sum) < Math.abs(best)) best = sum;
        }

        System.out.println(best);
    }

}