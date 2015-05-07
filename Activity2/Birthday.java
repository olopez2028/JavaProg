
public class Birthday {
	public static void main(String[] args) { 
        int D = 365; //Integer.parseInt(args[0]);     // number of days
        int people = 0;                        // total number of people
        
        int peopleCounter = 0;

        //  days[d] = true if someone born on day d; false otherwise
        //  auto-initialized to false
        boolean[] days = new boolean[D];

        for(int i=0; i<20; i++){
        
	        while (true) {
	            people++;
	            int d = (int) (D * Math.random());    // integer between 0 and D-1
	            if (days[d]) break;                   // two people with the same birthday, so break out of loop
	            days[d] = true;                       // update days[d]	            
	        }
	
	        System.out.println(people);
	        peopleCounter += people;
        }
        
        System.out.println("Average number of people after 20 rounds: " + peopleCounter/20);
    }
}
