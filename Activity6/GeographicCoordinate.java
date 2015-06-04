
public class GeographicCoordinate {
	private int degrees;
    private int minutes;
    private int seconds; 
    private boolean sign;
    
    public GeographicCoordinate(int degrees, int minutes, int seconds, boolean sign) {        
        if (sign)
        	this.degrees = degrees * -1;
        else
        	this.degrees = degrees;
    	
        this.minutes = minutes;
        this.seconds = seconds;       
    }
    
    public String toString() {       
    	int degrees;
    	if (this.sign)
    		degrees = this.degrees * -1;
    	else
    		degrees = this.degrees;
    	
    	return "(" + degrees + "° " + minutes + "' " + seconds + "'')";
    }
    
    public static void main(String[] args) {   
    	GeographicCoordinate loc1 = new GeographicCoordinate(36, 30, 15, false);
    	System.out.println("Geographic location 1: " + loc1.toString());
    	
    	GeographicCoordinate loc2 = new GeographicCoordinate(36, 30, 15, true);
    	System.out.println("Geographic location 2: " + loc2.toString());
    }
}
