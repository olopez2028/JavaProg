/*************************************************************************
 *  Compilation:  javac HexTiile.java
 *  Execution:    java HexTile N
 *  Dependencies: StdDraw.java
 *
 *  Create an N-by-N hexagonal tile.
 *
 *************************************************************************/

public class HexTile {
    public static void hexagon(double x, double y, double size) {
        double c1 = Math.sqrt(3) / 2;
        double c2 = .5;
        double[] px = { x + c1*size, x + c1*size, x,        x - c1*size, x - c1*size, x        };
        double[] py = { y - c2*size, y + c2*size, y + size, y + c2*size, y - c2*size, y - size };
        StdDraw.polygon(px, py);
    }

    public static void filledHexagon(double x, double y, double size) {
        double c1 = Math.sqrt(3) / 2;
        double c2 = .5;
        double[] px = { x + c1*size, x + c1*size, x,        x - c1*size, x - c1*size, x        };
        double[] py = { y - c2*size, y + c2*size, y + size, y + c2*size, y - c2*size, y - size };
        StdDraw.filledPolygon(px, py);        
    }
    
    

    public static void main(String[] args) {
        double c = Math.sqrt(3) / 2;
        int N = Integer.parseInt(args[0]) + 1;
        int[][] pascal = new int[N+1][];
        
        StdDraw.setCanvasSize(900, 600);
        StdDraw.setXscale(-1, 3*N/2);
        StdDraw.setYscale(-1, N);
              
        // initialize first row
        pascal[1] = new int[1 + 2];
        pascal[1][1] = 1;

        // fill in Pascal's triangle
        for (int i = 2; i <= N; i++) {
            pascal[i] = new int[i + 2];
            for (int j = 1; j < pascal[i].length - 1; j++)
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
        }
                
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < pascal[i].length - 2; j++) {
            	
                StdDraw.setPenRadius();
                StdDraw.setPenColor(StdDraw.BLACK);
                filledHexagon(i-.5*j, j*c, .5/c);
                StdDraw.setPenRadius(.005);
                StdDraw.setPenColor(StdDraw.WHITE);
                hexagon(i-.5*j, j*c, .5/c);
                
                StdDraw.setPenRadius();
            	StdDraw.setPenColor(StdDraw.WHITE);
            	StdDraw.text(i-.5*j, j*c, pascal[N-j][i-j] + " ");
                               	
                	
            }
        }
             
       
    }                
}
