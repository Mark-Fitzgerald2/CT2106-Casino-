package casino;

public class ConcreteDeck  implements Deck{

	private Card[] cards = null; 
	/*
	 * public Constructor with arguments.
	 */
	public ConcreteDeck() {
		//TODO initialise the cards array (size 52)
		//then insert a new unique (and valid) Card for each of the array slots
		//Your deck can't include duplicates
		cards = new Card[52]; //initialises the cards array to a size of 52
		int count = 0; //creates a simple counter
		for (int s = 0; s<4; s++){ //loops for every suit
			for (int r = 1; r<14; r++){ //loops for every rank
				cards[count] = new Card(s, r); //stores each card in the array
				count++; //updates counter
			}
		}
		
	} 
	/*
	 * returns a String representation of the array of Card
	 * e.g Ace of Clubs, Two of Clubs, Three of Clubs,..
	 */
	public String toString(){
		//TODO
		String list = ""; //creates string variable
		for(Card card : this.cards){ //for every value in card
			list += (card+" "); //get the name of the value from Card class
		}
		return list; //returns list
	}
	
	@Override
	public void shuffle(){
		for(int counter = 0; counter < 104; counter++){ //shuffles the deck. This is run 104 times to make sure its shuffled
			Card oldCard = new Card(0,0); //creates a new card
			if (counter >= 52){ //if the card is greater than or equal to 52 
				int count = (int)(counter / 2); //we need to divide counter by 2 to stop an out of bounds exception
				oldCard = this.cards[count]; //store the new card to whatever value is currently at this point in the array
			} else {
				oldCard = this.cards[counter]; //otherwise we can just store the value to the new card straight away
			}
			int pos1 = (int)(Math.random()*52); //chooses a random number between 0 and 52
			if (counter >= 52){ //again checks the stage at which the counter is at
				int count = (int)(counter / 2); //if the counter is larger than the array size we create count
				this.cards[count] = this.cards[pos1]; //stores the value in the array at pos1 to card at count
			} else {
				this.cards[counter] = this.cards[pos1]; //stores the value in the array at pos1 to card at count
			}
			this.cards[pos1] = oldCard; //stores the card value stored above to pos1
		} //overall this switches the position of two cards
	}
	
	@Override
	public Card removeTopCard(){
		//TODO
		Card topCard = this.cards[this.cards.length -1]; //chooses card at the final position
		Card[] newCardsArray = new Card[this.cards.length -1]; //new array which is one size smaller than cards
		for (int i =0; i <  this.cards.length - 1; i++){ //cycles through each card in Cards array bar one
			newCardsArray[i] = this.cards[i]; //stores each value in new array
		}
		cards = newCardsArray; //updates old array to equal the new array
		return topCard; //returns the removed card
	}
}


