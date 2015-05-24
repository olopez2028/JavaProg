/*************************************************************************
 *  Compilation:  javac RecursiveSquares.java
 *  Execution:    java RecursiveSquares N
 *  Dependencies: StdDraw.java
 *
 *  Plot an order N tree of overlapping gray squares.
 *
 *  % java RecursiveSquares 4
 *
 *************************************************************************/

public class RecursiveSquares {

    // plot a square, centered on (x, y) of the given side length
    // with a light gray background and black border
    public static void drawSquare(double x, double y, double size) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, size/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size/2);
    }

    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length => option a)
    public static void drawOptionA(int n, double x, double y, double size) {
        if (n == 0) return;

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller trees of order n-1             
        drawOptionA(n-1, x - size/2, y - size/2, size/ratio);    // lower left  
        drawOptionA(n-1, x - size/2, y + size/2, size/ratio);    // upper left  
        drawOptionA(n-1, x + size/2, y - size/2, size/ratio);    // lower right 
        drawOptionA(n-1, x + size/2, y + size/2, size/ratio);    // upper right   
        
        drawSquare(x, y, size);        
    }
    
    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length => option b)
    public static void drawOptionB(int n, double x, double y, double size){
    	if (n == 0) return;

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller trees of order n-1                     
        drawOptionB(n-1, x - size/2, y + size/2, size/ratio);    // upper left 
        drawOptionB(n-1, x + size/2, y + size/2, size/ratio);    // upper right  
        drawSquare(x, y, size);
        drawOptionB(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        drawOptionB(n-1, x + size/2, y - size/2, size/ratio);    // lower right                              
    }
    
    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length => option c)
    public static void drawOptionC(int n, double x, double y, double size){
    	if (n == 0) return;

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller trees of order n-1  
        drawOptionC(n-1, x - size/2, y + size/2, size/ratio);    // upper left          
        drawOptionC(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        drawOptionC(n-1, x + size/2, y - size/2, size/ratio);    // lower right 
        drawSquare(x, y, size);         
        drawOptionC(n-1, x + size/2, y + size/2, size/ratio);    // upper right
            
    }
    
    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length => option d)
    public static void drawOptionD(int n, double x, double y, double size){
    	if (n == 0) return;

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller trees of order n-1             
        drawOptionD(n-1, x - size/2, y - size/2, size/ratio);    // lower left  
        drawOptionD(n-1, x - size/2, y + size/2, size/ratio);    // upper left  
        drawOptionD(n-1, x + size/2, y - size/2, size/ratio);    // lower right 
        drawOptionD(n-1, x + size/2, y + size/2, size/ratio);    // upper right   
        
        drawSquare(x, y, size);
    }


    // read in a command-line argument N and plot an order N recursive
    // squares pattern
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   // center of square
        double size = 0.5;         // side length of square
        drawOptionC(N, x, y, size);
    }

}
