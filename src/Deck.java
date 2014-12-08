
public class Deck {
    private java.util.ArrayList<Card> _deck; // instantiates the deck
    
    public Deck () {
        this.generateNewDeck(); // generates the deck
    }
    
    public final void generateNewDeck() {
        this._deck = new java.util.ArrayList<>(); // Fills the Deck arraylist
        for (int i = 1; i <= 52; i++) {
            this._deck.add(new Card(i));
        }
        java.util.Collections.shuffle(this._deck);
    }
    
    public Card draw() { // Draw the card from the top of the deck (first element)
        if (!this._deck.isEmpty()) {
            return this._deck.remove(0);
        } else {
            this.generateNewDeck();
            return this.draw();
        }
    }
    
    // Getters and Setters
    public java.util.ArrayList<Card> getDeck() {
        return this._deck;
    }
    
}
