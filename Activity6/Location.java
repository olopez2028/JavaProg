import java.util.Random;

public class Location {  
    private double longitude;
    private double latitude;   
   
    // create and initialize a point with given
    // (latitude, longitude) specified in degrees
    public Location(double latitude, double longitude) {        
        this.latitude  = latitude;
        this.longitude = longitude;
    }
    
    
    //generate a random Location
    public static Location getRandomLocation(){
    	Random random = new Random();
    	return new Location((random.nextDouble() * -180.0) + 90.0,
                (random.nextDouble() * -360.0) + 180.0);    	
    }
    
    
    // return distance between this location and that location in miles 
    public double distanceTo(Location that) {
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }

    // return string representation of this point
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }


    // test client
    public static void main(String[] args) {       
    	Location loc1 = getRandomLocation();    	    	   
    	System.out.println("Random location 1: " + loc1.toString());
    	
    	Location loc2 = new Location(25.344, 63.5532);
    	System.out.println("Location 2: " + loc2.toString());
    	
    	double distance = loc1.distanceTo(loc2);
    	System.out.println("Total distance from location 1 to location 2: " + distance + " miles.");    
    }
}