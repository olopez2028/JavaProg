/*************************************************************************
  *  Compilation:  javac DiamondTile.java
  *  Execution:    java DiamondTile N
  *  Dependencies: StdDraw.java
  *
  *  Create an N-by-N diamond tile.
  *************************************************************************/

public class DiamondTile {

   // draw a diamond outline, center at (x, y), diagonals = 2*size 
   public static void diamond(double x, double y, double size) {
      double[] px = { x + size, x,        x - size, x        };
      double[] py = { y,        y + size, y       , y - size };
      StdDraw.polygon(px, py);
   }

   // draw a filled diamond, center at (x, y), diagonals = 2*size
   public static void filledDiamond(double x, double y, double size) {
      double[] px = { x + size, x,        x - size, x        };
      double[] py = { y,        y + size, y       , y - size };
      StdDraw.filledPolygon(px, py);
   }
      
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);

      // for easy computation, set scale to match pattern
      StdDraw.setXscale(0, N);
      StdDraw.setYscale(0, N);

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {        	
        	 if ((i + j) % 2 != 0){ 
        		 StdDraw.setPenColor(StdDraw.BLACK);
        		 StdDraw.filledSquare(i + .5, j + .5, .5); 
        	 }
             else
             {                  
            	 StdDraw.setPenColor(StdDraw.RED);
            	 StdDraw.square(i + .5, j + .5, .5);
             }             
         }
      }
   }                
}