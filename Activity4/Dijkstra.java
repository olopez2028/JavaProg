import java.util.HashMap;
import java.math.BigInteger;

public class Dijkstra {
	 private static HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
	    private static BigInteger TWO  = new BigInteger("2");
	    private static BigInteger ONE  = BigInteger.ONE;
	    private static BigInteger ZERO = BigInteger.ZERO;

	    public static BigInteger fibonacci(BigInteger n) {
	        if (n.equals(ZERO)) return ZERO;
	        if (n.equals(ONE))  return ONE;
	        if (cache.containsKey(n)) return cache.get(n);

	        // odd
	        if (n.testBit(0)) {
	            BigInteger n2 = n.shiftRight(1);
	            BigInteger n3 = n2.add(ONE);
	            BigInteger result = fibonacci(n2).multiply(fibonacci(n2)).add(fibonacci(n3).multiply(fibonacci(n3)));
	            cache.put(n, result);
	            return result;
	        }

	        // even
	        else {
	            BigInteger n2 = n.shiftRight(1);
	            BigInteger n3 = n2.subtract(ONE);
	            BigInteger result = fibonacci(n2).multiply(fibonacci(n2).add(fibonacci(n3).add(fibonacci(n3))));
	            cache.put(n, result);
	            return result;
	        }
	    }

	    public static void main(String[] args) { 
	        BigInteger N = new BigInteger(args[0]);
	        System.out.println(fibonacci(N));	       
	    }
}
