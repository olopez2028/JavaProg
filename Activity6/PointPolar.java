/*************************************************************************
 *  Compilation:  javac PointPolar.java
 *  Execution:    java PointPolar
 *
 *  Implementation of 2D point using polar coordinates.
 *
 *************************************************************************/

public final class PointPolar {
    private final double r;
    private final double theta; 
   
    // constructor
    PointPolar() {
        double x = Math.random();
        double y = Math.random();
        r = Math.sqrt(x*x + y*y); 
        theta = Math.atan2(y, x);
    }

    PointPolar(double x, double y) {
        r = Math.sqrt(x*x + y*y); 
        theta = Math.atan2(y, x);
    }

    double r()     { return r;                 }
    double theta() { return theta;             }
    double x()     { return r*Math.cos(theta); }
    double y()     { return r*Math.sin(theta); }

    double distanceTo(PointPolar that) {
        double dx = this.x() - that.x();
        double dy = this.y() - that.y();
        return Math.sqrt(dx*dx + dy*dy);
    }

    public String toString()  { return "(" + x() + ", " + y() + ")"; } 



    // test client
    public static void main(String[] args) {
        PointPolar p = new PointPolar();
        System.out.println("p  = " + p);
        System.out.println("   x     = " + p.x());
        System.out.println("   y     = " + p.y());
        System.out.println("   r     = " + p.r());
        System.out.println("   theta = " + p.theta());
        System.out.println();

        PointPolar q = new PointPolar(0.5, 0.5);
        System.out.println("q  = " + q);
        System.out.println("dist(p, q) = " + p.distanceTo(q));
    }
}
