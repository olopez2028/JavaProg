
public class FunctionGrowth {
	public static void main(String[] args) { 
	      System.out.println("log N         \tN     \tN log N \tN^2 \tN^3");
	      for (float i = 2; i <= 1073741824; i *= 2) {
	         System.out.print((float) Math.log(i));
	         System.out.print('\t');             // tab character
	         System.out.print(i);
	         System.out.print('\t');             
	         System.out.print((float) (i * Math.log(i)));
	         System.out.print('\t');             
	         System.out.print(i * i);
	         System.out.print('\t');             
	         System.out.print(i * i * i);
	         System.out.println();
	      }
	   }
}
