
public class IBMDigitVerification {
	
	public static boolean IsValidCreditCard(String cardNumber){
		int cardLength;		
		int modResult;
		
		cardLength = cardNumber.length();	
		
		int total = 0;
		int multiplier = 2;
		
		for (int i = cardLength - 2; i >= 0; i--){
			int currentDigit = Character.getNumericValue(cardNumber.charAt(i));
			if ( (currentDigit * multiplier) >= 10 ){
				total += ((currentDigit * multiplier ) / 10) + ((currentDigit * multiplier ) % 10 ); 
			}else{
				total += currentDigit * multiplier;
			}
			
			if (multiplier == 2){
				multiplier = 1;
			}else{
				multiplier = 2;
			}
		}
		
		modResult = total % 10;		
				
		if(modResult == 0)
		    return true;
		else		
			return false;
	}
	
	
	public static void main (String[] args){
		String cardNumber = args[0];
		
		if (cardNumber.length() == 16){
			
			boolean isValid = IsValidCreditCard(cardNumber);
			
			if (isValid)
				System.out.println("The credit card number " + cardNumber + " IS VALID!");
			else
				System.out.println("The credit card number " + cardNumber + " IS INVALID!");
			
		}else{
			System.out.println("Invalid card length!");
		}
	}
	
}
