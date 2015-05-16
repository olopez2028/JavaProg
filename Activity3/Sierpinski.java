// Stuart Reges
// 10/25/06
//
// Program that draws the Sierpinski fractal.

import java.awt.*;
import java.util.*;

public class Sierpinski {
    public static final int SIZE = 512;  // height/width of DrawingPanel   
    public static double area = 0;

    public static void main(String[] args) {
        // prompt for level
        Scanner console = new Scanner(System.in);
        System.out.print("What level do you want? ");
        int level = console.nextInt();

        // initialize drawing panel
        DrawingPanel p = new DrawingPanel(SIZE, SIZE);
        p.setBackground(Color.CYAN);
        Graphics g = p.getGraphics();

        // compute triangle endpoints and begin recursion
        int triangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
        Point p1 = new Point(0, triangleHeight);
        Point p2 = new Point(SIZE / 2, 0);
        Point p3 = new Point(SIZE, triangleHeight);
        
        double area = drawFigure(level, g, p1, p2, p3);       
                
        int blackInvertedTriangles = 0;
        int uprightWhiteTriangles = 0;
        
        blackInvertedTriangles = (int)Math.pow(3, level - 1);
        uprightWhiteTriangles = (int)(blackInvertedTriangles - 1) / 2;
        
        System.out.println("No. of black inverted triangles: " + blackInvertedTriangles);
        System.out.println("No. of upright white triangles: " + uprightWhiteTriangles);
        
        System.out.println("Total Black Area = " + area);
    }

    // Draws a Sierpinski fractal to the given level inside the triangle
    // whose vertices are (p1, p2, p3).
    public static double drawFigure(int level, Graphics g,
                                  Point p1, Point p2, Point p3) {    	
    	int triangleHeight = 0;
    	int triangleBase = 0;
    	
        if (level == 1) {
            // base case: simple triangle
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p3.x, p3.y);
            g.fillPolygon(p);
            
            triangleBase = p3.x - p1.x;
            triangleHeight = (int)Math.round(triangleBase * Math.sqrt(3.0) / 2.0);
            
            area += triangleArea(triangleBase, triangleHeight); 
            
        } else {
            // recursive case, split into 3 triangles
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);

            // recurse on 3 triangular areas
            drawFigure(level - 1, g, p1, p4, p6);
            drawFigure(level - 1, g, p4, p2, p5);
            drawFigure(level - 1, g, p6, p5, p3);
                    
        }
        
        return area;
    }

    // returns the midpoint of p1 and p2
    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
    
    
    //return area of a triangle
    public static double triangleArea(double base, double height){
    	return (base * height ) / 2;
    }
    
}