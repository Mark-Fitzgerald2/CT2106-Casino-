package casino;

public class ConcreteHand  implements Hand{
	
	private Card[] cards;
	
	public ConcreteHand(int n){
		
		//TODO you will need to initialise the cards variable with an array of size n
		cards = new Card[n]; //creates an array of size n
	}
	/*
	 * This method adds a Card to the cards array
	 */
	public void addCard(Card card){
		//TODO you need to insert a Card to the array
		//You'll need to have kept track of how many cards have been added already
		//so that you add the card in the right place (i.e. immediately after the last added one)
		for(int i=0; i < cards.length; i++){ //cycles through the array
			if ( cards[i] == null){ //finds first empty spot in array
				cards[i] = card; //stores the card passed in to the array
				break;
			}
		}
	}
	
	/*
	 * This method prints out the hand
	 * e.g. Ace of Clubs, 3 of Diamonds, Jack of Hearts, etc
	 */
	
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("\nYour Hand is:"); //prints to screen
		for(int i =0; i < cards.length; i++){ //cycles through the array
			if(i == cards.length - 1){ //checks if i has gotten to a value of one less than the size of the array
				System.out.print(cards[i].toString() + "."); //changes the comma to a full stop
			} else{
				System.out.print(cards[i].toString() + ", "); //prints the array as a string
			}
		}
	}
}
