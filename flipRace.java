/**
 * Author: Brandon B.
 * Date: 9-24-15
 * Description: Flips two coins repeatitively until one gets heads 3 times in a row
 */

public class flipRace {
    public static void main(String[] args) {
        final int coinGoal = 3;
        int coinCount1 = 0, coinCount2 = 0;
        boolean lastCoin1, lastCoin2, isNewGame = true;

        Coin coin1 = new Coin();
        Coin coin2 = new Coin();

        while (coinCount1 < coinGoal && coinCount2 < coinGoal) {
        	coin1.flip();
        	coin2.flip();

        	lastCoin1 = coin1.isHeads();
        	lastCoin2 = coin2.isHeads();
        	if (isNewGame) {
        		isNewGame = false;

        		// This is their first flip.
        		lastCoin1 = coin1.isHeads();
        		lastCoin2 = coin2.isHeads();

        		coinCount1++;
        		coinCount2++;

        		// Restart this
        		continue;
        	}

        	if (lastCoin1 == coin1.isHeads()) {
        		// The user has another match!
        		coinCount1++;
        	}
        	else {
        		// Boo hoo, they didn't match their last result.
        		coinCount1 = 1;
        	}

        	if (lastCoin2 == coin2.isHeads()) {
        		// The user has another match!
        		coinCount2++;
        	}
        	else {
        		// Boo hoo, they didn't match thier last result.
        		coinCount2 = 1;
        	}

        	System.out.printf("Coin 1: %s%nCoin 2: %s", coin1.toString(), coin2.toString());
        }
        if ((coinCount1 == coinGoal) && (coinCount2 != coinGoal))
        	System.out.println("Coin 1 wins!");
        else if ((coinCount2 == coinGoal) && (coinCount1 != coinGoal))
        	System.out.println("Coin 2 wins!");
        else
        	System.out.println("It's a tie!");
    }
}
