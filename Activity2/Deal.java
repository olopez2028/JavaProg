import java.io.*;

public class Deal {	
	public static void main(String[] args) throws IOException{
        int CARDS_PER_PLAYER = 5;

        // number of players
        int PLAYERS = Integer.parseInt(args[0]);
        
        //card for user 1
        String[] userCards = new String[6];
        
        //card for hose
        String[] houseCards = new String[5];

        String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        // avoid hard-wired constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        int CARDS = SUITS * RANKS;

        if (CARDS_PER_PLAYER * PLAYERS > CARDS) throw new RuntimeException("Too many players");

        // initialize deck
        String[] deck = new String[CARDS];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
            }
        }

        // shuffle
        for (int i = 0; i < CARDS; i++) {
            int r = i + (int) (Math.random() * (CARDS-i));
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }

        // give cards for user 1
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
        	userCards[i] = deck[i];                        
        }
        
        if (PLAYERS > 1){   
        	// shuffle
            for (int i = 0; i < CARDS; i++) {
                int r = i + (int) (Math.random() * (CARDS-i));
                String t = deck[r];
                deck[r] = deck[i];
                deck[i] = t;
            }
        	
	        // give cards for house 1
	        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
	        	houseCards[i] = deck[i];                        
	        }    
        }
        
        //print user 1 cards
        System.out.println("User 1 cards:");
        for (int i = 0; i < userCards.length - 1; i++)
        	System.out.println(userCards[i]);
        
        System.out.println();
        
        if (PLAYERS > 1){        
	        //print house cards
	        System.out.println("House cards:");
	        for (int i = 0; i < houseCards.length; i++)
	        	System.out.println(houseCards[i]);
        }
        
        System.out.println();
        
        System.out.println("Additonal card?(Y/N)");
        char option = (char)System.in.read();  
        
        System.out.println();
        
        if (option == 'y' || option == 'Y'){        	
        	//print additional card
        	userCards[5] = deck[1];    
        	
        	System.out.println("User 1 cards plus Hit:");
        	
        	for (int i = 0; i < userCards.length; i++)
            	System.out.println(userCards[i]);
        }
    }
}
