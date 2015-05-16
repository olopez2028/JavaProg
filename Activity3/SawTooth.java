/*************************************************************************
 *  Compilation:  javac SawTooth.java
 *  Execution:    java SawTooth N
 *  
 *  Plots an approximation to a sawtooth wave via Fourier analysis.
 *
 *************************************************************************/


public class SawTooth { 
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(1400, 500);
        StdDraw.setXscale(0, 6 * Math.PI);
        StdDraw.setYscale(-2, 2);

        StdDraw.show(0);
        double xprev = 0.0;

        for (double t = 0.0; t <= 6*Math.PI; t+= 0.005) {
            double x = 0.0;
            for (int k = 1; k <= N; k++) {            	
            	for(int i = 0; i<= 10000; i+=2){
            		
            		x+= (Math.sin((k+i)*t) / (k+i));
            	}            	
            }
            x = x * 2 / Math.PI;
            StdDraw.line(t - 0.005, xprev, t, x);
            xprev = x;
        }
        StdDraw.show(0);
        
       
    }
}