package interfaces;

import java.util.Arrays;
import java.util.List; 

public class Card implements Comparable<Card>{
	private char suit;
	private int face;
	final static List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');
	
	int thisWon = 1; 
	int thisLost = -1; 
	
	public Card(char inSuit, int inFace){
		if(inSuit != 'S' && inSuit != 'H'&& inSuit != 'D' && inSuit != 'C' ){
			throw new IllegalArgumentException("Invalid suit");
		}
		else if(inFace < 1 || inFace > 13){
			throw new IllegalArgumentException("Invalid face");
		}
		suit = inSuit; face = inFace; 
	}
	
	char getSuit(){
		return suit; 
	}
	
	int getFace(){
		return face;
	}
	
	public String toString(){
		return String.valueOf(suit) + String.valueOf(face);
	}
	
	@Override
	public int compareTo(Card compCard){
		if(suits.indexOf(compCard.getSuit()) > suits.indexOf(suit)){
			return thisLost; 
		}
		else if(suits.indexOf(compCard.getSuit()) < suits.indexOf(suit)){
			return thisWon; 
		}
		else{
			int faceDiff = face - compCard.getFace();
			if(faceDiff != 0){
				faceDiff =  faceDiff/Math.abs(faceDiff);
			}
			return faceDiff*thisWon; 
		} 
	}
}