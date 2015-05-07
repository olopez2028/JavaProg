
public class Binary {
	public static void main(String[] args) { 
       
        // For storing remainder
        int rem;
           
        // For storing result
        String str2="";
        
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        
        for(int i=1; i <= 256; i++){
        	
        	int num = i;
        	str2 = "";
        	
        	while(num>0)
            {
              rem=num%16; 
              str2=hex[rem]+str2; 
              num=num/16;
            }
            
        	System.out.println("Number " + i + " to hexadecimal: "+str2);        
        }        
	}
}
