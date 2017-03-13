package interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
	
	boolean aceWins;
	char trumf;
	
	int c1Won = 1;
	int c2Won = -1; 
	
	//List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');
	List<Character> suits = new ArrayList<Character>();
	
	/*
	 * Constructor:
	 * Currenctly has no form of validation
	 */
	public CardComparator(boolean setAceToHighest, char inTrumf) {
		aceWins = setAceToHighest;
		
		suits.add('C'); suits.add('D'); suits.add('H'); suits.add('S');
		trumf = inTrumf;
	}
	
	/*
	 * Ekstra-oppgave: Tømmer suits-listen og lager den på nytt i rekkefølgen fra newOrder
	 */
	public void setSuitOrder(char[] newOrder){
		suits.clear();
		for(char s: newOrder){
			suits.add(s); 
		}
	}
	
	/*
	 * General/abstract controller to compare cards. 
	 * First checks suits, then faces/numbers
	 */
	@Override
	public int compare(Card c1, Card c2) {
		
		if(this.compareSuits(c1, c2) != 0){
			return this.compareSuits(c1, c2);
		}
		else{
			return this.compareFaces(c1, c2);
		}
		//return 0;
	}

	/*
	 * Compares suits
	 * First checks if a single card is trumf, then compares them normally. 
	 * Note: if both have trumfs, normal comparison tells they're equals
	 */
	int compareSuits(Card c1, Card c2){
		if(c1.getSuit() == trumf && c2.getSuit() != trumf){
			return c1Won;
		}
		else if(c1.getSuit() != trumf && c2.getSuit() == trumf){
			return c2Won;
		}
		else{
			if(suits.indexOf(c1.getSuit()) > suits.indexOf(c2.getSuit())){
				return c1Won;
			}
			else if(suits.indexOf(c1.getSuit()) < suits.indexOf(c2.getSuit())){
				return c2Won;
			}
			else{
				return 0;
			}	 
		}
		
	}
	
	/*
	 * Compares faces (numeric values)
	 * If ace (1) is ranked highest, and at least one card is ace, checks which has the ace
	 * If ace is not highest, runs a simple difference-test. 
	 * Note: if c1 is highest, a positive integer is returned. 
	 */
	int compareFaces(Card c1, Card c2){
		if(aceWins && (c1.getFace() == 1 || c2.getFace() == 1)){
			if(c1.getFace() < c2.getFace()){
				return c1Won;
			}
			else if(c1.getFace() > c2.getFace()){
				return c2Won;
			}
			else{
				return 0;
			}
		}
		else{
			int faceDiff = c1.getFace() - c2.getFace();
			return (int)faceDiff/Math.abs(faceDiff);
		}
	}
}
