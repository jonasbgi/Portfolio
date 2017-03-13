package encapsulation;
import java.util.*;
 

public class CardDeck {
	List<Card> deck = new ArrayList<>(); 
	char[] suits = {'S', 'H', 'D', 'C'};
	
	public CardDeck(int n){
		if(n < 1 || n > 13){
			throw new IllegalArgumentException("Invalid amount of cards");
		}
		Card newCard; 
		for(char s: suits){
			for(int a = 1; a <= n; a++){
				newCard = new Card(s, a);
				deck.add(newCard); 
			}
		}
	}
	
	void shufflePerfectly(){
		int splitIndex = Math.round(deck.size()/2);
		/*if(Float.valueOf(splitIndex) < deck.size()/2){
			splitIndex --;
		}
		*/
		List<Card> newDeck = new ArrayList<Card>(); 
		
		List<Card> topHalf = deck.subList(0, splitIndex);
		List<Card> btmHalf = deck.subList(splitIndex, deck.size());
		
		Card firstCard;
		Card secCard;
		
		for(int i = 0; i < splitIndex; i++){
			firstCard = topHalf.get(i);
			secCard = btmHalf.get(i);
			
			newDeck.add(firstCard);
			newDeck.add(secCard);
		}
		
		deck = newDeck;
	}
	
	int getCardCount(){
		return deck.size();
	}
	
	Card getCard(int n){
		if(n >= 0 && n < deck.size()){
			return deck.get(n);
		}
		else{
			throw new IllegalArgumentException("Invalid card index");
		}
	}
}
